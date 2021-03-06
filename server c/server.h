#include <stdio.h>
#include <stdlib.h>
#include <sys/socket.h>
#include <unistd.h>
#include <netinet/in.h>
#include <pthread.h>

/* Function prototypes */
void* handle_client(void *client_socket);

/* Preprocessor directives */
#define SERVER_ADDR "127.0.0.1" // for client
#define PORT 21995              // port the server will listen on

#define FALSE 0
#define TRUE !FALSE

#define NUM_CONNECTIONS 2      // number of pending connections in the connection queue
