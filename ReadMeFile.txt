FetchTypes :
In Spring Boot, eager loading and lazy loading are strategies for fetching related entities from the database.
These strategies are typically used in the context of JPA (Java Persistence API) and Hibernate to manage how and when associated entities are loaded.

EagerLoading : Eager loading fetches the related entities immediately along with the main entity.
LazyLoading : Lazy loading fetches the related entities only when they are explicitly accessed.

Cascading : Cascading is a technique where multiple methods or functions are called on the same object sequentially in a single line of code.
It improves code readability and can be implemented using method chaining.

Cascade Types :
Type 1 : ALL
-> If cascade is set to all, then whatever operation we do on parent entity it propagates to associated entity.

Type 2 : PERSIST
-> If cascade set to PERSIST, when we store parent entity in db, then same operation propagates to
   associated entity.
-> If we do delete author id, then it gives an exception since author id is foreign key in books.
   To delete author id even when cascade sets to PERSIST, set orphanRemoval = true in annotation, then
   it deletes author from authors table and as well deletes from books table.

Type 3 : REMOVE
-> If cascade set to REMOVE, When we delete parent entity then it deletes associated entity also.
-> For example if we delete author, then it deletes all books which were associated with that author in
   books table.

Type 4 : DETACH
-> If cascade set to detach, that means whatever operation does on parent, that will not reflect on
   associated entity, means associated entity detached from parent entity.
-> Crate new author and store in db, then it stores author only, doesn't store associated entities(books).