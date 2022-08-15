# writerapplication

Project Document:
Spring boot REST API Application is for WRITER Operations.

Tech stack : Java 1.8, Spring boot,REST API.

Rest based URL for accessing Writer operation:

1.Write to File : 
POST :http://localhost:8086/api/v1/FileWriter/Writer

2.Read from File:
GET:http://localhost:8086/api/v1/FileWriter/reader/FileWriter

3.close file writer:
http://localhost:8086/api/v1/FileWriter/close

1.Write to String : 
POST :http://localhost:8086/api/v1/StringWriter/Writer

2.Read from String:
GET:http://localhost:8086/api/v1/StringWriter/reader

3.close String writer:
http://localhost:8086/api/v1/FileWriter/close

Request is passed as JSON format.
