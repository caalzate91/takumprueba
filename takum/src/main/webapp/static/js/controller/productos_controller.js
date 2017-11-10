'use strict';

angular.module('myApp').controller('ProductosController', ['$scope', 'ProductosService', function($scope, ProductosService) {
    var self = this;
    self.productos={prodcodi:null,prodcost:null,prodnomb:'',proddesc:'',prodcapr:null,produsua:null};
    self.productos=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;


    fetchAllProductos();

    function fetchAllProductos(){
        ProductosService.fetchAllProductos()
            .then(
            function(d) {
                self.productos = d;
            },
            function(errResponse){
                console.error('Error while fetching Productos');
            }
        );
    }

    function createProductos(productos){
        ProductosService.createProductos(productos)
            .then(
            fetchAllProductos,
            function(errResponse){
                console.error('Error while creating Productos');
            }
        );
    }

    function updateProductos(productos, id){
        productoservice.updateProductos(productos, id)
            .then(
            fetchAllProductos,
            function(errResponse){
                console.error('Error while updating Productos');
            }
        );
    }

    function deleteProductos(id){
        ProductosService.deleteProductos(id)
            .then(
            fetchAllProductos,
            function(errResponse){
                console.error('Error while deleting Productos');
            }
        );
    }

    function submit() {
        if(self.productos.prodcodi===null){
            console.log('Saving New Productos', self.productos);
            createProductos(self.productos);
        }else{
            updateProductos(self.productos, self.productos.prodcodi);
            console.log('Productos updated with id ', self.productos.prodcodi);
        }
        reset();
    }

    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.productos.length; i++){
            if(self.productos[i].prodcodi === id) {
                self.productos = angular.copy(self.productos[i]);
                break;
            }
        }
    }

    function remove(id){
        console.log('id to be deleted', id);
        if(self.productos.prodcodi === id) {
            reset();
        }
        deleteProductos(id);
    }


    function reset(){
        self.productos={prodcodi:null,prodcost:null,prodnomb:'',proddesc:'',prodcapr:null,produsua:null};
        $scope.myForm.$setPristine(); //reset Form
    }

}]);
