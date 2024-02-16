package Homework_22_01_2024;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimilarToStream<T> {
    private Collection<T> collection;

    //Конструктор для инициализации объекта SimilarToStream с переданной коллекцией
    private SimilarToStream(Collection<T> collection) {
        this.collection = collection;
    }

    //Статический метод для создания объекта SimilarToStream с переданной в качестве аргумента коллекцией
    public static <T> SimilarToStream<T> of(Collection<T> collection) {
        return new SimilarToStream<>(collection);
    }

    //Метод для фильтрации элементов коллекции, использует функциональный интерфейс Predicate
    public SimilarToStream<T> filter(Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T element : collection) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return new SimilarToStream<>(filteredList);
    }

    //Метод для преобразования элементов коллекции, использует функциональный интерфейс Function
    public <R> SimilarToStream<R> transform(Function<T, R> mapper) {
        List<R> transformedList = new ArrayList<>();
        for (T element : collection) {
            transformedList.add(mapper.apply(element));
        }
        return new SimilarToStream<>(transformedList);
    }

    //Метод для конвертации элементов в мапу, используется функциональный интерфейс Function для ключей и значений
    public <K, V> Map<K, V> toMap(Function<T, K> keyMapper, Function<T, V> valueMapper) {
        Map<K, V> resultMap = new HashMap<>();
        for (T element : collection) {
            resultMap.put(keyMapper.apply(element), valueMapper.apply(element));
        }
        return resultMap;
    }

    public static void main(String[] args) {
        //Создаем коллекцию с некоторыми объектами класса Person
        List<Person> someCollection = Arrays.asList(new Person("Alice", 25), new Person("Bob", 30), new Person("Charlie", 22));

        //Прменяем фильтрацию, трансформацию объекта и корвертируем элементы в мапу
        Map<String, Person> result = SimilarToStream.of(someCollection)
                .filter(p -> p.getAge() > 20)
                .transform(p -> new Person(p.getName(), p.getAge() + 30))
                .toMap(Person::getName, p -> p);

        //Выводим результат манипуляций
        for (Person p: someCollection) {
            System.out.println("This is " + p.getName() + ", he/she is " + p.getAge() + " y.o.");
        }
    }
}
