# 🧪 14-Day Spring Boot Practice Challenge

Tracking my progress as I learn Spring Boot deeply through a structured hands-on challenge.

---

## 📅 Daily Progress

| Day | Topic | Task | Done? | Notes |
|-----|-------|------|-------|-------|
| 1 | Project Setup | Manual Spring Boot project + mySQL | ✅/⬜ |  |
| 2 | REST Controller | GET /hello endpoint | ✅/⬜ |Learned how to use @GetMapping to create an endpoint|
| 3 | @RequestParam | GET /square?num=5 | ✅/⬜ |Used @GetMapping to create an endpoint and @RequestParam for the Query|
| 4 | @PathVariable | GET /greet/{name} | ✅/⬜ |Used @PathVariable to get data right from the URL|
| 5 | @Service + DI | Service class logic | ✅/⬜ |Learned how to put the logic in the service class and inject it into the controller class  |
| 6 | Component Types | Compare @Service vs @Component | ✅/⬜ |Found out that Spring treats these classes the same(from what I know)  |
| 7 | Entity | Create Book entity | ✅/⬜ |Created a book entity using annations such as @Entity, @Id, @GeneratedValue and use lombok @Data to create getters/setters|
| 8 | JPA Repository | Save/fetch from DB | ✅/⬜ | Created a book repository interface that extends JpaRepository, allowing me access to the basic CRUD methods |
| 9 | POST Book | Use @RequestBody to add book | ✅/⬜ | Used @PostMapping to send data to the database and @RequestBody to automatically deserialize the data |
| 10 | GET Book by ID | Use path variable | ✅/⬜ |Learning about using ResponseEntity to return a 404 not found error and learning how to use @DeleteMapping and @PathVariable to delete a book using Postman |
| 11 | DELETE + Error Handling | Handle not found | ✅/⬜ | Used @PutMapping to update a Book. Learning more about ResponseEntity and how it lets you control the HTTP status. Also, using a ? makes the method generic allowing you to return anything |
| 12 | Relationships | Book has Reviews | ✅/⬜ |  |
| 13 | Nested GET | Fetch reviews by book | ✅/⬜ |  |
| 14 | Wrap Up | Refactor or use MySQL | ✅/⬜ |  |

---

## 🌱 Motivation
I want to become confident using Spring Boot to build real-world apps. This challenge is helping me move from tutorial-watching to hands-on problem-solving.
