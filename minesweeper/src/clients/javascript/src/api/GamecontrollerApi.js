/**
 * Api Documentation
 * Api Documentation
 *
 * OpenAPI spec version: 1.0
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 *
 * Swagger Codegen version: 2.2.3
 *
 * Do not edit the class manually.
 *
 */

(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['ApiClient', 'model/BoardApi', 'model/GameConfigApi'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/BoardApi'), require('../model/GameConfigApi'));
  } else {
    // Browser globals (root is window)
    if (!root.ApiDocumentation) {
      root.ApiDocumentation = {};
    }
    root.ApiDocumentation.GamecontrollerApi = factory(root.ApiDocumentation.ApiClient, root.ApiDocumentation.BoardApi, root.ApiDocumentation.GameConfigApi);
  }
}(this, function(ApiClient, BoardApi, GameConfigApi) {
  'use strict';

  /**
   * Gamecontroller service.
   * @module api/GamecontrollerApi
   * @version 1.0
   */

  /**
   * Constructs a new GamecontrollerApi. 
   * @alias module:api/GamecontrollerApi
   * @class
   * @param {module:ApiClient} apiClient Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the createNewGameUsingPOST operation.
     * @callback module:api/GamecontrollerApi~createNewGameUsingPOSTCallback
     * @param {String} error Error message, if any.
     * @param {module:model/BoardApi} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Create a new Board for a Game
     * @param {module:model/GameConfigApi} gameConfigApi gameConfigApi
     * @param {module:api/GamecontrollerApi~createNewGameUsingPOSTCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/BoardApi}
     */
    this.createNewGameUsingPOST = function(gameConfigApi, callback) {
      var postBody = gameConfigApi;

      // verify the required parameter 'gameConfigApi' is set
      if (gameConfigApi === undefined || gameConfigApi === null) {
        throw new Error("Missing the required parameter 'gameConfigApi' when calling createNewGameUsingPOST");
      }


      var pathParams = {
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = ['application/json'];
      var accepts = ['application/json'];
      var returnType = BoardApi;

      return this.apiClient.callApi(
        '/game/create', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the markCellUsingPOST operation.
     * @callback module:api/GamecontrollerApi~markCellUsingPOSTCallback
     * @param {String} error Error message, if any.
     * @param {module:model/BoardApi} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Mark/unmark a cell
     * @param {Number} id id
     * @param {module:api/GamecontrollerApi~markCellUsingPOSTCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/BoardApi}
     */
    this.markCellUsingPOST = function(id, callback) {
      var postBody = null;

      // verify the required parameter 'id' is set
      if (id === undefined || id === null) {
        throw new Error("Missing the required parameter 'id' when calling markCellUsingPOST");
      }


      var pathParams = {
        'id': id
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = ['application/json'];
      var accepts = ['application/json'];
      var returnType = BoardApi;

      return this.apiClient.callApi(
        '/game/markCell/{id}', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the openCellUsingPOST operation.
     * @callback module:api/GamecontrollerApi~openCellUsingPOSTCallback
     * @param {String} error Error message, if any.
     * @param {module:model/BoardApi} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Open a cell
     * @param {Number} id id
     * @param {module:api/GamecontrollerApi~openCellUsingPOSTCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/BoardApi}
     */
    this.openCellUsingPOST = function(id, callback) {
      var postBody = null;

      // verify the required parameter 'id' is set
      if (id === undefined || id === null) {
        throw new Error("Missing the required parameter 'id' when calling openCellUsingPOST");
      }


      var pathParams = {
        'id': id
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = ['application/json'];
      var accepts = ['application/json'];
      var returnType = BoardApi;

      return this.apiClient.callApi(
        '/game/openCell/{id}', 'POST',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the resumeGameUsingGET operation.
     * @callback module:api/GamecontrollerApi~resumeGameUsingGETCallback
     * @param {String} error Error message, if any.
     * @param {module:model/BoardApi} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Resume a previous game board
     * @param {Number} id id
     * @param {module:api/GamecontrollerApi~resumeGameUsingGETCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {@link module:model/BoardApi}
     */
    this.resumeGameUsingGET = function(id, callback) {
      var postBody = null;

      // verify the required parameter 'id' is set
      if (id === undefined || id === null) {
        throw new Error("Missing the required parameter 'id' when calling resumeGameUsingGET");
      }


      var pathParams = {
        'id': id
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = BoardApi;

      return this.apiClient.callApi(
        '/game/resume/{id}', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
