**Список тест кейсов:**

**1. Создание нового контакта:**
- Заполнить поле "First name"
- Заполнить поле "Last Name"
- Выбрать новую категорию контакта
- Установить дату рождения через календарь
- Вписать адрес в поле Address
- Нажать на кнопку "Create Contact"
- Проверить, что счетчик контактов обновился на +1
- Найти контакт по id и проверить, что карточка контакта в листе контактов создалась и отображается (через Action)
- Проверить полное совпадение данных фамилии + имени и адреса созданного контакта с данными, которые мы использовали для создания контакта

**2. Проверка невозможности создания пустой карточки контакта**
- Не заполнять ни одно из полей
- Нажать на кнопку "Create Contact"
- Проверить, что счетчик контактов не обновился

**3. Проверка обновления данных существующего контакта**
- Выбрать первый контакт из списка
- Удалить данные из поля "First name"
- Ввести новые данные в поле "First name"
- Нажать на кнопку "Update Contact"
- Найти контакт с измененными данными
- Проверить, что First Name контакта совпадает с данными, которые мы использовали для обновления данных контакта

**4. Генерация 50 контактов**
- Не заполнять ни одно из полей
- Нажать на кнопку "Generate 50 Contacts"
- Проверить, что счетчик контактов обновился на +50
- Найти последний созданный контакт по ID и проверить, что карточка контакта создалась в листе контактов и отображается (через Action)


**Note: Первый и последний тест кейсы будет падать, потому что:**
- Selenium долго ищет контакт с ID 250
- Мощности моего компьютера не позволяют быстро проскролить такой нестандартный список (пришлось значительно увеличивать implicitlyWait). Если вы измените ID на, допустим, 15, то Action отработает быстро и четко. Если бы такой список попался бы мне на реальном проекте, то я бы:
  1. Проверил бы создание контакта через API;
  2. Возможно предложил бы изменить реализацию списка, либо уточнить еще способы поиска быстрого нахождения созданного контакта.
