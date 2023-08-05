# Computer and Mobile Networks

## Client Brief

For devices to communicate on a WAN or distributed system, protocols need to be established. The OSI and TCP architectures and suites of protocols enable all devices to communicate with each other using a variety of protocols and services. TCP and UDP are the two packet types used on an 802.x network.
Given this, the aim is to create a simple client server system to demonstrate (via output statements): the communications between the client and server and the actions within each. Your system should include the following functionality:
Functional Requirements
  - Your program must set and close sessions of communication
  - Write a simple STOP and WAIT protocol for UDP
  - In the packet, the byte payload will include both the original data and a sequence number for the packet (SN=x)
  - The data in the file to be sent between the client/server should contain the string ‘umbrella’
  - You need to identify and include UDP ports for the communication endpoints
  - Your client must take an IP address or Hostname and port number as arguments
  - The port number is the port number the server must listen on
  - The sender must read the line of data from the file and combine that text with the sequence number and send the packet to the receiver.

## Outputs
Your system should output to the command console clear statements to demonstrate the interactions and functionality.
Non-Functional Requirements
Your code must be commented throughout
Best practice should also be applied to your code.

## Technical Requirements 
The application is built using Java (Liberica JDK 11)
The application runs from the Command Console
