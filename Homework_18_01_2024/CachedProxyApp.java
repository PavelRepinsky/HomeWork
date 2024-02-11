package Homework_18_01_2024;

import java.awt.*;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Homework_18_01_2024.CachedProxyApp.HardWorkImpl.*;
import static Homework_18_01_2024.FileToZip.isZip;

public class CachedProxyApp {

    public static class HardWorkImpl implements HardWork, ReturnList, Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        public static CacheSettings settings = new CacheSettings();

        public static String path = null;

        //Метод позволяет указать путь, по которому будет храниться кеш после сериализации
        public static void setPath(String newPath) {
            path = newPath;
        }

        public HardWorkImpl() throws IOException {
        }

        //Можем выбрать где будет храниться файл с кешем и как он будет называться (в случае сериализации)
        public void changePathSetting(String newPath) {
            path = newPath;
        }

        @Override
        public String doHardWork() {
            //Типа усиленно трудимся
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hard work result";
        }

        @Override
        public ArrayList<String> returnedList() {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ArrayList<String> list = new ArrayList<>();

            list.add("odin");
            list.add("dva");
            list.add("Tri");
            list.add("ChetbIre");
            list.add("Pyat'");

            return list;
        }
    }

    public static class CachedProxy implements InvocationHandler {
        private Object target;
        private Map<Method, Object> cache = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();

        private CachedProxy(Object target) {
            this.target = target;
        }

        public static HardWork createCachedProxy(HardWork target) {
            return (HardWork) Proxy.newProxyInstance(
                    target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    new CachedProxy(target)
            );
        }

        public static ReturnList createCachedProxyList(ReturnList target) {
            return (ReturnList) Proxy.newProxyInstance(
                    target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    new CachedProxy(target)
            );
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            //Указываем путь куда будем сериализовывать наш кеш (будем использовать дефолтное значение настройки)
            if (path == null) {
                path = "C:/Users/20655284/IdeaProjects/SberEducationV2/src/main/java/Homework_18_01_2024/SaveSuda/" + method.getName() + ".txt";
            }

            //Проверяем помечен ли метод аннотацией @Cached
            if (method.isAnnotationPresent(Cached.class)) {
                if (!cache.containsKey(method)) {
                    //Провереряем возвращает ли метод List и отмечен ли он аннотацией LimitSize
                    if (method.getReturnType().equals(ArrayList.class) && method.isAnnotationPresent(LimitSize.class)) {
                        ArrayList<String> result = (ArrayList<String>) method.invoke(target, args);
                        ListTrimer listTrimer = new ListTrimer();
                        //Задаем сколько элементов списка нужно кешировать
                        listTrimer.setAmount(-3);
                        if (listTrimer.getAmount() != 0) {
                            try {
                                listTrimer.trimList(result);
                            } catch (TrimListException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        //Проверяем где будем хранить кеш, в памяти или сериализуем
                        if (settings.isInMemory()) {
                            cache.put(method, result);
                        } else if (settings.isSerializeResult()) {
                            ObjectOutputStream objectOutputStream = null;
                            FileOutputStream outputStream = null;
                            try {
                                outputStream = null;
                                objectOutputStream = null;

                                //создаем 2 потока для сериализации объекта и сохранения его в файл
                                outputStream = new FileOutputStream(path);
                                objectOutputStream = new ObjectOutputStream(outputStream);

                                objectOutputStream.writeObject(result);
                            } finally {
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                    cache.put(method, result);
                                }
                            }
                        }
                    }
                    else {
                        Object result = method.invoke(target, args);
                        if (settings.isInMemory()) {
                            cache.put(method, result);
                        } else if (settings.isSerializeResult()) {
                            ObjectOutputStream objectOutputStream = null;
                            FileOutputStream outputStream = null;
                            try {
                                outputStream = null;
                                objectOutputStream = null;

                                outputStream = new FileOutputStream(path);
                                objectOutputStream = new ObjectOutputStream(outputStream);

                                objectOutputStream.writeObject(result);
                            } finally {
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                cache.put(method, result);
                                //Проверяем необходимо ли упаковывать в zip архив
                                if (isZip()) {
                                    FileToZip ftz = new FileToZip((String) result, method.getName());
                                }
                            }
                        }
                        return result;
                    }
                } else {
                    System.out.println("Returning cached result");

                    if(settings.isInMemory()) {
                        return cache.get(method);
                    }
                    else if (settings.isSerializeResult()) {

                        FileInputStream fileInputStream = new FileInputStream(path);
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                        return objectInputStream.readObject();
                    }
                }
            }
            return method.invoke(target, args);
        }
    }

    public static void main(String[] args) throws IOException {

        //Работаем с методом, который возвращает String
        HardWork hardWork = new HardWorkImpl();
        HardWork cachedProxy = CachedProxy.createCachedProxy(hardWork);

        System.out.println(cachedProxy.doHardWork()); // Займёт какое-то время
        System.out.println(cachedProxy.doHardWork()); // Вернёт кешированный результат


        //Работаем с методом, который возвращает ArrayList<String>
        ReturnList returnList = new HardWorkImpl();
        ReturnList cachedProxyList = CachedProxy.createCachedProxyList(returnList);

        System.out.println(cachedProxyList.returnedList()); //Создаем лист и возвращаем его
        System.out.println(cachedProxyList.returnedList()); //Вернём кешированный и укороченный лист
    }
}
