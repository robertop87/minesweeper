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
    // AMD.
    define(['expect.js', '../../src/index'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    factory(require('expect.js'), require('../../src/index'));
  } else {
    // Browser globals (root is window)
    factory(root.expect, root.ApiDocumentation);
  }
}(this, function(expect, ApiDocumentation) {
  'use strict';

  var instance;

  beforeEach(function() {
    instance = new ApiDocumentation.GameConfigApi();
  });

  var getProperty = function(object, getter, property) {
    // Use getter method if present; otherwise, get the property directly.
    if (typeof object[getter] === 'function')
      return object[getter]();
    else
      return object[property];
  }

  var setProperty = function(object, setter, property, value) {
    // Use setter method if present; otherwise, set the property directly.
    if (typeof object[setter] === 'function')
      object[setter](value);
    else
      object[property] = value;
  }

  describe('GameConfigApi', function() {
    it('should create an instance of GameConfigApi', function() {
      // uncomment below and update the code to test GameConfigApi
      //var instane = new ApiDocumentation.GameConfigApi();
      //expect(instance).to.be.a(ApiDocumentation.GameConfigApi);
    });

    it('should have the property boardSize (base name: "boardSize")', function() {
      // uncomment below and update the code to test the property boardSize
      //var instane = new ApiDocumentation.GameConfigApi();
      //expect(instance).to.be();
    });

    it('should have the property initColumn (base name: "initColumn")', function() {
      // uncomment below and update the code to test the property initColumn
      //var instane = new ApiDocumentation.GameConfigApi();
      //expect(instance).to.be();
    });

    it('should have the property initRow (base name: "initRow")', function() {
      // uncomment below and update the code to test the property initRow
      //var instane = new ApiDocumentation.GameConfigApi();
      //expect(instance).to.be();
    });

    it('should have the property playerName (base name: "playerName")', function() {
      // uncomment below and update the code to test the property playerName
      //var instane = new ApiDocumentation.GameConfigApi();
      //expect(instance).to.be();
    });

  });

}));
