SimilarToStream v0.1

Выполненное задание представлено двумя файлами:
1. SimilarToStream.java - основной класс, включающий в себя все нужные методы;
2. Person.java - класс Person был написан с целью проверки работы методов основного класса

При выполнении задания использовались функциональные интерфейсы Predicate и Function.

SimilarToStream(Collection<T> collection) - Конструктор для инициализации объекта SimilarToStream с переданной коллекцией

SimilarToStream<T> of(Collection<T> collection) - Статический метод для создания объекта SimilarToStream с переданной в качестве аргумента коллекцией

Метод filter - метод для фильтрации элементов коллекции, использует функциональный интерфейс Predicate;
Метод transform - метод для преобразования элементов коллекции, использует функциональный интерфейс Function;
Метод toMap - метод для конвертации элементов в мапу, используется функциональный интерфейс Function для ключей и значений