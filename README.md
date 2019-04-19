**Astral Plane**

This is a Web Application called The Astral Plane. It's a small project I work on when I find the time to further my understanding of Spring Boot, Hibernate, Flyway, and Bootstrap to design a simple web application. I play Dungeons and Dragons for fun, so I decided to create a simple web app that I can use to find spells quickly.

I decided to use PostgreSQL as my database since I had never worked with it before and wanted to broaden my experience. I decided that my strategy for database work would be to leverage SpringBoots strengths by integrating Flyway to make database changes as the application starts. I use Hibernate to validate the schema changes during startup, to make sure that Models and Tables would interact as expected and I build queries using Hibernate for spell filtering with predicates.

The rest of the application is mostly boiler plate code with very ugly UI work using Bootstrap and Thymeleaf. This was my first time using Bootstrap and I was impressed with the amount it helped me accomplish. I look forward to working more with it.

**Tools/Tech Used**
*  Spring Boot
*  PostrgeSQL
*  Hibernate
*  Flyway
*  Bootstrap
*  Thymeleaf