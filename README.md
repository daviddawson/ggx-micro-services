# Groovy Micro Services

This repository contains code samples and slides used in the presentation 'Groovy Micro Services using Spring Boot' first delivered at the Groovy and Grails Exchange 2013 in London

## About David Dawson

David Dawson is the CEO and Principal Consultant at Simplicity Itself, a consultancy based on the UK.

## About Simplicity Itself

Simplicity Itself are a different kind of software development and consultancy shop based in the UK.
Founded with the mission of simplifying software development in order to overcome the challenge of software and software development practices that cannot embrace the change inherent in agile software development, Simplicity Itself is made up of international speakers, book authors and open source contributors who are dedicated to increasing the value that our client’s get from their software development through our products, consultancy, courses and books.

[http://www.simplicityitself.com](http://www.simplicityitself.com)


## Yummy Noodle Bar

Welcome to the Yummy Noodle Bar!

![Yummy Noodle Bar](images/yummynoodle.jpg)

Hot on the heels of their recent global expansion, the Yummy Noodle Bar employed the Awesome Consultancy Company (that's you!), to build them a new, scalable Order Processing application.

They already have a system built at the start of their expansion, but it is having issues in design, maintenance and addition of new features. They have asked you to build new additions to the system.

## The Current Architecture : All hail the Monolith

![A Monolith](images/monolith.jpg)

The current application is a monolithic application, with multiple REST/ JSON interfaces, a web UI, kitchen integration and stores data in MongoDB.

Being monolithic, this application is starting to suffer from some issues related to its design and nature.

Adding new REST interfaces is becoming problematic, as the core domain model is tightly woven into the rest of the application.  Creating new views is becoming difficult in code as the current domain model is now highly complex and cannot be feasibly extended to support the new modes of access without significant rework.

These problems are well known.

## What do we want?

You are tasked with adding a new set of REST interfaces to the system to add and retrieve orders.

These additions need to be independently scalable, reliable, distributable and able to be changed quickly in response to changing market conditions.

If we were to try to add these into the existing system, it would take weeks to specify and alter the domain model, set up the routes for the data, test for regressions and fully deploy.

You have 30 minutes.

## Micro Services?

Since this is not enough time to make an addition to a monolithic style system, we will be investigating another method to augment systems, another method to structure applications.

Enter the Micro Service.

There is no hard and fast set of rules on what makes a Micro Service, but for the purposes of this talk, they are applications that are :-

 * Short, a few hundred lines long at most.
 * Share functionality, not code, by cooperating with other services.
 * Are granular to the task at hand.
 * Are small enough that they can be created and thrown away as required
 * Integrate using HTTP or a message bus
 * Remember SOA?
 
Since the TODO

Mention a bunch of tech that could be used to implement this pattern.

 * Sinatra/ Ruby
 * Scalatra/ Scala
 * Ring/ Clojure
 * Ratpack/ Groovy.

## Spring Boot

TODO, introduce and discuss spring boot.  We will use groovy!

What is it?   Spring with an opinion!  

A default configuration, based on your classpath.  You can then override as you need to.
TODO - Succinct Spring.
TODO - A set of starter libraries that set you up with a default context quickly.
TODO - Actuator, a set of management and monitoring endpoints, with no configuraton!  Just add to you classpath. 



## Building a Micro Service based Application Structure

Firstly, we will use Spring Boot to create a service to find and read orders from MongoDB, and a service to insert orders into Mongo.

### Front Controller

In order to quickly add new functionality to the existing system, we need a method to direct certain URLs to the new services, while allowing the rest of the application to continue running.

In this setup, Nginx works well enough as a reverse proxy, selecting by incoming URL which service to forward requests to.

This provides the users view of the complete 'application'.  It takes all of the externally accessible URIs and presents a single, coherent application.

TODO - set up nginx, show how... at least store in repo.

### Order Persistence Service

TODO, write up properly.
This portion is to show the nicer setup of spring configuration.  should it show what is being replaced?
This is a nicer way to do spring.  Set up using gradle.

```
java -jar build/libs/yummy-command-0.1.jar  --server.port=7080
```

Since we are persisting, we need validations and contracts.  This can be done in the write portion (ie this one) using an
object/ type to model and enforce the schema we want.

discuss the need for a schema, validation, type.

Using spring data mongo.
All needed configuration enabled by default using the annotations.

create a basic controller, build and run, showing an http endpoint.

add a form bean, showing data binding.
add validation, showing schema managamenet

finally, add mongo integration/ repository and annotations.





<demo data appearing in mongo>
TODO INTEGRATE ACTUATOR! and demo it...?


### Order Query Service

TODO
 - this is nice, but not truly micro.  how many lines of config, directories etc...
 
This service reads the data from MongoDB

The rest interface is the only abstraction we actually need, so we don't need to create another one using an object mapper.
Don't be afraid of knowing that you are using MongoDB in your code!  

This allows some interesting code transformations to be applied functionally (TODO like what?)

```
gvm use springboot
```

Write a simple http endpoint ("/orders/{orderId") & run
show blended into the same url space via the front controller



## Testing..? 

TODO - mockMVC?

## Trade Offs

This isn't perfect, of course.

TODO, describe what we've done.

traded latency for scalability and throughput
traded deployment complexity for deployment flexibility and options (give example, deploy part of the application in a DMZ?)
gained:
ease of extension
comprehensibility
scalability and throughput.
discoverability becomes an issue

lost:
latency

## Next Steps.

Install [GVM](http://gvmtool.net)

```
curl -s get.gvmtool.net | bash
```

Install Spring Boot

```
gvm use springboot
```

Go!



