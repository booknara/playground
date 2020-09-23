# System design practice


## Materials
1. Grokking the System Design Interview [1]
2. Designing Data Intensive Applications
3. System Design Primer [2] 

## An approach to solve system design within 1 hour
1. Functional requirements / use cases - 2 ~  5 minutes (a lot of discussion needed)
2. Non-functional requirements(NFR - scalability, latency, CAP(consistency, availability, partition tolerance), durability) - 2 minutes
3. Capacity estimation - max 2 ~ 5 minutes
4. Start generic high level design(HLD) - covering in-flow and outflow of data - 5 ~ 10 minutes
5. Data Model / APIs (if applicable) - 5 minutes
6. Scale each component in HLD depending on NFR - 10 minutes
7. Verify your design / Discuss trade-offs of the design (important) - 5 minutes

10(requirement analysis) - 15(HLD, API) - 15(Scale, Discussion)

Reference
1. CAP theorem [3]
2. Consistent Hashing[4] 

##Overview of Scalability
There are several reasons to require scaling database
1. Support a higher volume of users
2. Provide better performance for existing users
3. Store a larger volume of data
4. Improve system availability
5. Geographic dispersion(generally related to performance and availability)

### Vertical scaling(scale up)
The easiest way to increase the capacity of database is to upgrade the server hardware(e.g. CPU, RAM, Disk I/O capacity)
1. Simplest and easiest option for scaling database
2. It doesn't improve availability (db is still running on one single instance)
3. Good for boosting CPU, RAM, but limited potential for improving network I/O and disk I/O
4. Expensive expense generally
5. It has a finite limit to scale up

### Horizontal scaling
Adding additional servers for high availability or failover. There are several types of way.
1. Active-Passive: With two database instances, one is the active instance, and the other is the passive. All read and write queries are directed to the active instance.
Write operations are replicated to the passive instance to keep it in sync. In the event of failure of the active instance, query and update traffic is redirected to the passive instance.
- Improves availability and failover
- Doesn't improve capacity and performance because one of instances(single instance) is used.
- In case of active instance failure, redirecting traffic from the active instance to the passive can be done automatically by a load-balancer or switch, or can be done manually using a VIP or internal DNS configuration change.
2. Master-Slave: 
3. Cluster:
4. Sharding: 

### SQL vs NoSQL
SQL(Relational database): It has predefined schemas like phone books that store phone numbers and address
1. Each row(tuple) contains all the information about one entity
2. Each column(tuple's property) contains all the separate data points
Most popular relational database are MySql, Oracl, MS SQL Server, SQLite, Postgres, and MariaDB

NoSQL(Non-relational database): It's unstructured, distributed and have a dynamic schema 
The most common types of NoSQL
- Key-Value Store: Data is stored in an array of key-value pairs. The 'key' is an attribute name which is linked to a 'value'. Well-known key-value stores include Redis, Voldemort, and Dynamo.
- Document Databases: In these databases, data is stored in documents (instead of rows and columns in a table) and these documents are grouped together in collections. Each document can have an entirely different structure. Document databases include the CouchDB and MongoDB.
- Wide-Column Databases: Instead of ‘tables,’ in columnar databases we have column families, which are containers for rows. Unlike relational databases, we don’t need to know all the columns up front and each row doesn’t have to have the same number of columns. Columnar databases are best suited for analyzing large datasets - big names include Cassandra and HBase.
- Graph Databases: These databases are used to store data whose relations are best represented in a graph. Data is saved in graph structures with nodes (entities), properties (information about the entities), and lines (connections between the entities). Examples of graph database include Neo4J and InfiniteGraph. 


License
-------
MIT License

Copyright (c) 2020 Daehee Han

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

[1]: https://www.educative.io/courses/grokking-the-system-design-interview
[2]: https://github.com/donnemartin/system-design-primer
[3]: https://medium.com/system-design-blog/cap-theorem-1455ce5fc0a0
[4]: https://medium.com/system-design-blog/consistent-hashing-b9134c8a9062