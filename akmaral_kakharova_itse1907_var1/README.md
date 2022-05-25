# LibraryManagementSystem

**Project description:** LMSystem is a software developed for managing basic functions of library like keeping records of borrowed books, new books, sorting them, keeping information about them. <br><br>
Today in libraries hard without tracking system. Thera are a lot of books and readers. It is unreal keep all information about each book in their mind. So, Library management system is required anywhere. <br><br>
LMS makes controlling all of this much easier, convenient and fast. Also, there is no need asking for books primarily librarian: everyone can use system in their needs.

**Project consists of packages: **
- authorization & security
  - Security classes
- config
  - 3 classes: appconfig, cacheConfig, SimpleCustomizer
- controller
  - 3 controllers: BookController, ProfileController, SecurityController
- jms
  - JmsController, MessageReceiver, MessageSender, MessagingConfiguration
- model
  - Book, Profile, Recomendations
- repository
  - BookRepository, ProfileRepository, RecomRepository (they are interfaces)
- validator
  - Simple Book Validator

**Project methods:**
*The system enables administrators to* 
-	Log in 
-	The addition, deletion and modification of books 
-	Search by author, name and etc
-	Tracking books: existing in library and borrowed
-	Payment details
*Readers*
-	Log in
-	See all books
-	Borrow and return books
-	Search by author, name and etc

**Modules:**
-	Insertion – for entering book, author information
-	Updating – update existing information.
-	ReportGeneration – show payments details for students.

**More about technicial parts:**
- As database used PostgreSql
- UML diagram is also included
- IOC, dependency injection
- Transactionality, JPA, queries
- REST API controllers: get, post, delete, put methods
- JMS messaging for managing errors
- Spring security, role based permissions

**REST API controller endpoints**

curl -X GET http://localhost:8080/book/allBooks <br>
curl -X POST http://localhost:8080/book/addBook <br>
curl -X DEL http://localhost:8080/book/deleteBook/1 <br>
curl -X PUT http://localhost:8080/book/updateBook/2 <br>
curl -X GET http://localhost:8080/profile/allProfiles <br>
curl -X POST http://localhost:8080/profile/addProfile <br>
curl -X DEL http://localhost:8080/profile/deleteProfile/1 <br>
curl -X PUT http://localhost:8080/profile/updateaddProfile/2 <br>
curl -X GET http://localhost:8080/book/getBooksByProfile <br>
curl -X POST http://localhost:8080/jms/sendMessage/checkJMS <br>
curl -X GET http://localhost:8080/jms/receiveMessage <br>

[//]: # (curl -X GET http://localhost:8080/book/findByAuthor <br>)

[//]: # (curl -X GET http://localhost:8080/book/findByGenre <br>)

[//]: # (curl -X GET http://localhost:8080/book/findByPublishedYear <br>)

[//]: # (curl -X GET http://localhost:8080/book/findById <br>)

[//]: # (curl -X GET http://localhost:8080/profile/findAll <br>)

[//]: # (curl -X GET http://localhost:8080/profile/findByFname <br>)

[//]: # (curl -X GET http://localhost:8080/profile/findByFnameAndLname <br>)

[//]: # (curl -X GET http://localhost:8080/profile/findByAge <br>)

[//]: # (curl -X GET http://localhost:8080/profile/findByLogin <br>)

**Postman screens:**
![img.png](img.png)

![img_1.png](img_1.png)

![img_2.png](img_2.png)

![img_3.png](img_3.png)

![img_4.png](img_4.png)
