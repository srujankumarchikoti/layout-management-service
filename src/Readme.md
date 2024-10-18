
# Layout Management Service

This microservice provides layout management functionalities for users and user groups within an application.

## Setup

1. **Navigate to the project directory:**

    ```bash
    cd layout-management-service
    ```

2. **Build the project using Maven:**

    ```bash
    mvn clean install
    ```

3. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```

## Usage

### Accessing the H2 Database Console

1. Open a web browser and navigate to: `http://localhost:8080/h2-console`

2. Use the following credentials:
    - **JDBC URL**: `jdbc:h2:mem:testdb`
    - **Username**: `sa`
    - **Password**: `password`

### Endpoints

#### Get All Layouts

- **URL**: `/api/layouts/all`
- **Method**: `GET`
- **Parameters**: None
- **Example**: `/api/layouts/all`

#### Assign Layout to User

- **URL**: `/api/layouts/assign/user/{userId}/layout/{layoutId}`
- **Method**: `POST`
- **Parameters**:
    - `userId`: ID of the user
    - `layoutId`: ID of the layout
- **Example**: `/api/layouts/assign/user/3/layout/2`

#### Assign Layout to Group

- **URL**: `/api/layouts/assign/group/{groupId}/layout/{layoutId}`
- **Method**: `POST`
- **Parameters**:
    - `groupId`: ID of the user group
    - `layoutId`: ID of the layout
- **Example**: `/api/layouts/assign/group/1/layout/2`

#### Update User Layout

- **URL**: `/api/layouts/update/user/{userId}/layout/{layoutId}`
- **Method**: `PUT`
- **Parameters**:
    - `userId`: ID of the user
    - `layoutId`: ID of the new layout
- **Example**: `/api/layouts/update/user/3/layout/4`

#### Update Group Layout

- **URL**: `/api/layouts/update/group/{groupId}/layout/{layoutId}`
- **Method**: `PUT`
- **Parameters**:
    - `groupId`: ID of the user group
    - `layoutId`: ID of the new layout
- **Example**: `/api/layouts/update/group/2/layout/5`

#### Get User Layout

- **URL**: `/api/layouts/user/{userId}`
- **Method**: `GET`
- **Parameters**:
    - `userId`: ID of the user
- **Example**: `/api/layouts/user/3`

#### Update Layout

- **URL**: `/api/layouts/{layoutId}`
- **Method**: `PUT`
- **Parameters**:
    - `layoutId`: ID of the layout to be updated
- **Body**:
  ```json
  {
    "name": "Updated Layout Name",
    "description": "Updated layout description."
  }
