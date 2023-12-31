# ClientInfoAPI
# Справка по API

## Добавление нового клиента

**URL:** `POST /api/products/{nameClient}`

**Описание:** Создает нового клиента с указанным именем.

## Добавление нового контакта клиента

**URL:** `POST /api/products/addContact/{clientId}`

**Параметры запроса:**
- `contactType` (тип контакта: "phone" или "email")
- `value` (номер телефона или адрес электронной почты)

**Описание:** Добавляет новый контакт указанного типа клиенту с заданным идентификатором.

## Получение списка клиентов

**URL:** `GET /api/products/getListClients`

**Описание:** Возвращает список всех клиентов.

## Получение информации по заданному клиенту (по id)

**URL:** `GET /api/products/getInfoClient/{clientId}`

**Описание:** Возвращает информацию о клиенте с указанным идентификатором, включая его контакты.

## Получение списка контактов заданного клиента

**URL:** `GET /api/products/getListContacts/{clientId}`

**Описание:** Возвращает список всех контактов заданного клиента.

## Получение списка контактов заданного типа заданного клиента

**URL:** `GET /api/products/getContactType`

**Параметры запроса:**
- `clientId` (идентификатор клиента)
- `contactType` (тип контакта: "phone" или "email")

**Описание:** Возвращает список контактов заданного типа для указанного клиента.
