**Описание:**\
Разработать программу, которая работает в соответствии с требованиями ниже.

**Функциональные требования:**\
Необходимо разработать класс _UniqueWordCounter_, который в качестве коллекции использует Map. Данный класс должен выполнять следующие задачи:

`void addWord(String word)` - добавляет строку и считает количество раз, которое она была добавлена;\
`int getMostFrequentWord()` - возвращает строку, которая была добавлена чаще всего;\
`void printWordsFrequency()` - печатает на экран содержимое коллекции, а также количество раз, которое слово было добавлено;\
**Нефункциональные требования:**\
Продемонстрировать работу методов с учетом логических требований.

**Опционально:** \
Написать тестовые сценарии для класса UniqueWordCounter в классе UniqueWordCounterTest.
Все тестовые сценарии должны отрабатывать без ошибок.

**Пример:**


`UniqueWordCounter wordCounter = new UniqueWordCounter();`\
`wordCounter.add("apple");`\
`wordCounter.add("mango");`\
`wordCounter.add("apple");`\
`wordCounter.getMostFrequentWord();` //Should return _"apple"_