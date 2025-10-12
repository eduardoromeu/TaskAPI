# API Documentation

## Add Task

This endpoint allows users to add a new task to the system. It accepts a JSON payload containing the task's details and returns a confirmation of the added task.

### Request

- **Method**: `POST`
    
- **URL**: `http://localhost:8080/tarefas`
    
- **Content-Type**: `application/json`
    

#### Request Body Parameters

The request body must be a JSON object with the following parameters:

- `nome` (string): The name of the task.
    
- `dataEntrega` (string): The due date for the task in the format `YYYY-MM-DD`.
    
- `responsavel` (string): The name of the person responsible for the task.
    

**Example Request Body:**

``` json
{
  "nome": "Configurar Stack",
  "dataEntrega": "2025-11-25",
  "responsavel": "Eduardo 4820330"
}

 ```

### Response

Upon successful creation of the task, the server will respond with a confirmation message. The structure of the response may include:

- `status` (string): A message indicating the success of the operation.
    
- `taskId` (string): The unique identifier for the newly created task.
    

**Example Response:**

``` json
{
  "status": "Task added successfully",
  "taskId": "12345"
}

 ```

### Notes

- Ensure that all required fields are provided in the request body.
    
- The due date should be in the correct format to avoid validation errors.

***

### Endpoint: `GET /tarefas`

This endpoint retrieves a list of tasks from the server. It does not require any request parameters.

#### Request

- **Method**: GET
    
- **URL**: `http://localhost:8080/tarefas`
    

#### Response

- **Status Code**: 200 OK
    
- **Content-Type**: application/json
    
- **Body**: An array of task objects. Each task object may include various fields, but the exact structure is not specified in the current documentation.
    

#### Notes

- The response will return an array of tasks, which may be empty if no tasks are available.
    
- Ensure that the server is running and accessible at the specified URL to receive a valid response.

***

### Update Task Information

This endpoint allows you to update the information of a specific task in the system. The task is identified by its unique ID, which is included in the URL.

#### Request

- **Method**: PUT
    
- **URL**: `http://localhost:8080/tarefas/{id}` (replace `{id}` with the task ID, e.g., `1`)
    

#### Request Body Parameters

The request body must be in JSON format and should include the following parameters:

- `nome` (string): The name of the task.
    
- `dataEntrega` (string): The due date for the task in the format `YYYY-MM-DD`.
    
- `responsavel` (string): The identifier for the person responsible for the task.
    

Example of a request body:

``` json
{
  "nome": "Desenvolvimento da API Rest",
  "dataEntrega": "2025-12-12",
  "responsavel": "Eduardo 4820330"
}

 ```

#### Response

On a successful update, the API will return a response with the following structure:

- **Status**: 200 OK
    
- **Content-Type**: application/json
    

``` json
{
  "id": 0,
  "nome": "",
  "dataEntrega": "",
  "responsavel": ""
}

 ```

The response will include the updated task information. Note that the `id` field may be returned as `0` if the task ID is not correctly processed.

Ensure that the input parameters are provided correctly to avoid errors in the update process.

***

### DELETE /tarefas/{id}

This endpoint is used to delete a task specified by the unique identifier `{id}` from the system. In this case, the identifier is `1`, which indicates that the task with this ID will be removed.

#### Request Format

- **Method**: DELETE
    
- **URL**: `{{baseURL}}/tarefas/{id}`
    
- **Path Parameter**:
    
    - `id`: (integer) The unique identifier of the task to be deleted. In this example, the ID is `1`.
        

#### Response Structure

Upon successful deletion of the task, the server responds with:

- **Status Code**: `200 OK`
    
- **Content-Type**: `text/xml`
    
- **Body**: The response body may contain an XML structure confirming the deletion, but in this instance, it is returned as `null`.
    

### Summary

This DELETE request is essential for managing tasks within the system, allowing users to remove tasks they no longer need. The successful execution of this request will result in the specified task being deleted, with a confirmation response indicating the operation's success. Ensure that the correct task ID is provided to avoid unintended deletions.

###### Generated with PostBot
