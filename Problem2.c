/* Problem Statement:
Verified on leetcode

994 Rotting tomatoes
https://leetcode.com/problems/rotting-oranges/

In a given grid, each cell can have one of three values:

    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.
 *
 * Time Complexity : O(n*m) where n is rows and m is cols
 * Space Complexity : O(n*m)
 */

enum {
    EMPTY,
    FRESH,
    ROTTEN
};

#define MAX_QUEUE_SIZE 110
#define ROW_COL 2
#define DIR_LEN 4

// A structure to represent a queue
typedef struct queue
{
    int front, rear, size;
    unsigned capacity;
    int** array;
}queue_t;

/**** Queue functions start ***/

queue_t* createqueue()
{
    queue_t* q = (queue_t*)calloc(1, sizeof(queue_t));
    q->array = (int **)calloc(MAX_QUEUE_SIZE, sizeof(int *));
    q->capacity = MAX_QUEUE_SIZE;
    q->front = q->size = 0; 
    q->rear = MAX_QUEUE_SIZE - 1;
    return q;
}
 
// queue is full when size becomes equal to the capacity 
int isFull(queue_t* queue)
{  return (queue->size == queue->capacity);  }
 
// queue is empty when size is 0
int isEmpty(queue_t* queue)
{  return (queue->size == 0); }
 
// Function to add an item to the queue.  It changes rear and size
void enqueue(queue_t* queue, int item_row, int item_col)
{
    int *item = NULL;
    if (isFull(queue)) {
        queue->array = (int **)realloc(queue->array, sizeof(int*) * queue->size * 2);
    }
    /* store row and col */
    item = (int *)malloc(sizeof(int) * ROW_COL);
    if (!item) {
        return;
    }
    item[0] = item_row;
    item[1] = item_col;
    queue->rear = (queue->rear + 1) % queue->capacity;
    queue->array[queue->rear] = item;
    queue->size = queue->size + 1;
    //printf("%ld enqueued to queue\n", item->data);
}
 
// Function to remove an item from queue.  It changes front and size
int* dequeue(queue_t* queue)
{
    if (isEmpty(queue))
        return NULL;
    int *item = queue->array[queue->front];
    queue->front = (queue->front + 1) % queue->capacity;
    queue->size = queue->size - 1;
    return item;
}

void free_queue(queue_t* queue) {
    free(queue->array);
    free(queue);
}


int orangesRotting(int** grid, int gridSize, int* gridColSize){
    
    int rowDir[] = {0,0,-1,1};
    int colDir[] = {1,-1,0,0};

    int curr_size = 0;
    int row_num = 0, col_num = 0;
    int *item = NULL;
    int final_time = 0;
    int num_of_fresh_oranges = 0;
    int row = 0, col = 0, idx = 0;
    queue_t *queue = NULL;
    
    /* Null cases */
    if (!gridSize || !(*gridColSize)) {
        return -1;
    }
    /* initialize queues */
    queue = createqueue();
    
    if (!queue) {
        printf("Failure to allocate queue\n");
        return 0;
    }
    /* Determine number of fresh oranges and add if any rotten oranges in queue */
    for (row = 0; row < gridSize; row++) {
        for (col = 0; col < *gridColSize; col++) {
            if (grid[row][col] == FRESH) {
                num_of_fresh_oranges++;
            } else if (grid[row][col] == ROTTEN) {
                enqueue(queue,row,col);
            }
        }
    }
    
    /* no fresh oranges. just return 0 */
    if (!num_of_fresh_oranges) {
      free_queue(queue);
      return final_time;
    }

    /* The idea is to do BFS such that we get the 4-directional oranges, if its fresh ,make it rotten and then
     * add it to the queue. */
    while (!isEmpty(queue)) {
        /* For the last case, when no more rotten oranges are left, we need it */
        if (num_of_fresh_oranges != 0)
            final_time++;

        curr_size = queue->size;
        for (idx = 0; idx < curr_size; idx++) {
            item = dequeue(queue);
            for (row = 0; row < DIR_LEN; row++) {

                row_num = item[0] + rowDir[row];
                col_num = item[1] + colDir[row];

                if ((row_num >= 0 && row_num < gridSize) && 
                    (col_num >= 0 && col_num < *gridColSize) && 
                    grid[row_num][col_num] == FRESH) {
                    grid[row_num][col_num] = ROTTEN;
                    num_of_fresh_oranges--;
                    enqueue(queue, row_num, col_num);
                } 
            }
            free(item);
        }

    }
    free_queue(queue);
    
    /* It means all fresh oranges are rotten now. nothing is left. */
    if (num_of_fresh_oranges == 0) {
        return final_time;
    } else {
        return -1;
    }

}




/* Execute it on LeetCode platform*/

