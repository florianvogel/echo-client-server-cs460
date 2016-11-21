/**
 * Author: Jayden Urch
 * Student No: 5388406
 * Email: jsu22@nau.edu
 *
 * Author: Florian Vogel
 * Student No: 5373720
 * Email: fv69@nau.edu
 *
 * Date: 10/06/2016
 */

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <sys/socket.h>
#include <arpa/inet.h>

int main(int argc, char** argv){

	int server_socket;                 // descriptor of server socket
    struct sockaddr_in server_address; // for naming the server's listening socket
	char message[1000];
	char reply[1000];

	if(argc != 3){
		fprintf(stderr, "Error: Incorrect arguements. Correct usage is - client ipAddress port");
		exit(1);
	}
	
    if ((server_socket = socket(AF_INET, SOCK_STREAM, 0)) == -1) {
        perror("Error creating socket");
        exit(1);
    }

    // name the socket (making sure the correct network byte ordering is observed)
    server_address.sin_family      = AF_INET;           // accept IP addresses
    server_address.sin_addr.s_addr = inet_addr(argv[1]); // connect to server on given interface
    server_address.sin_port        = htons((int) strtol(argv[2],(char **)NULL,10));      // port to send on

     // binding unnamed socket to a particular port
    if (connect(server_socket, (struct sockaddr *)&server_address, sizeof(server_address)) == -1) {
        perror("Error binding socket");
        exit(1);
    }

	while(1){
		//reading user input
		scanf("%s", message);
		if(send(server_socket, message, strlen(message), 0) == -1){
            puts("Send failed");
            return 1;
        }
         
        //Receive a reply from the server
        if(recv(server_socket, reply ,1000 ,0) == -1)
        {
            puts("recv failed");
            break;
        }

        printf("%s\n", reply);
    }

    close(server_socket);
    return 0;
}
