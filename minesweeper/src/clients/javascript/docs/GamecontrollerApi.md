# ApiDocumentation.GamecontrollerApi

All URIs are relative to *https://deviget-minesweeper.appspot.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createNewGameUsingPOST**](GamecontrollerApi.md#createNewGameUsingPOST) | **POST** /game/create | Create a new Board for a Game
[**markCellUsingPOST**](GamecontrollerApi.md#markCellUsingPOST) | **POST** /game/markCell/{id} | Mark/unmark a cell
[**openCellUsingPOST**](GamecontrollerApi.md#openCellUsingPOST) | **POST** /game/openCell/{id} | Open a cell
[**resumeGameUsingGET**](GamecontrollerApi.md#resumeGameUsingGET) | **GET** /game/resume/{id} | Resume a previous game board


<a name="createNewGameUsingPOST"></a>
# **createNewGameUsingPOST**
> BoardApi createNewGameUsingPOST(gameConfigApi)

Create a new Board for a Game

### Example
```javascript
var ApiDocumentation = require('api_documentation');

var apiInstance = new ApiDocumentation.GamecontrollerApi();

var gameConfigApi = new ApiDocumentation.GameConfigApi(); // GameConfigApi | gameConfigApi


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.createNewGameUsingPOST(gameConfigApi, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **gameConfigApi** | [**GameConfigApi**](GameConfigApi.md)| gameConfigApi | 

### Return type

[**BoardApi**](BoardApi.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="markCellUsingPOST"></a>
# **markCellUsingPOST**
> BoardApi markCellUsingPOST(id)

Mark/unmark a cell

### Example
```javascript
var ApiDocumentation = require('api_documentation');

var apiInstance = new ApiDocumentation.GamecontrollerApi();

var id = 789; // Number | id


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.markCellUsingPOST(id, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 

### Return type

[**BoardApi**](BoardApi.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="openCellUsingPOST"></a>
# **openCellUsingPOST**
> BoardApi openCellUsingPOST(id)

Open a cell

### Example
```javascript
var ApiDocumentation = require('api_documentation');

var apiInstance = new ApiDocumentation.GamecontrollerApi();

var id = 789; // Number | id


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.openCellUsingPOST(id, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 

### Return type

[**BoardApi**](BoardApi.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="resumeGameUsingGET"></a>
# **resumeGameUsingGET**
> BoardApi resumeGameUsingGET(id)

Resume a previous game board

### Example
```javascript
var ApiDocumentation = require('api_documentation');

var apiInstance = new ApiDocumentation.GamecontrollerApi();

var id = 789; // Number | id


var callback = function(error, data, response) {
  if (error) {
    console.error(error);
  } else {
    console.log('API called successfully. Returned data: ' + data);
  }
};
apiInstance.resumeGameUsingGET(id, callback);
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Number**| id | 

### Return type

[**BoardApi**](BoardApi.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

