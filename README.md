# Play Framework 2.3.x and OpenJPA integration

OpenJPA can be used with Play Framework instead of (assumed) Hibernate.

Key difference to Hibernate is that model classes need to be enhanced after compile and before running the application.

Running the OpenJPA Enhancer is triggered within a task in build.sbt.
