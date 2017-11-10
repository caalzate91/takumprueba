'use strict';

angular.module('myApp').factory('ProductosService', ['$http', '$q', function($http, $q){

    var REST_SERVICE_URI = 'http://localhost:8080/takumprueba/productos/';

    var factory = {
        fetchAllProductos: fetchAllProductos,
        createProductos: createProductos,
        updateProductos:updateProductos,
        deleteProductos:deleteProductos
    };

    return factory;

    function fetchAllProductos() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Productos');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function createProductos(productos) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, productos)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Productos');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }


    function updateProductos(productos, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI+id, productos)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating Productos');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function deleteProductos(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Productos');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

}]);
