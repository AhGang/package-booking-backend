package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.PackageOrder;
import com.oocl.packagebooking.service.PackageOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/package-orders")
public class PackageOrderController {
    @Autowired
    PackageOrderService packageOrderService;


    @GetMapping
    public ResponseEntity getAllPackageOrders() {
        List<PackageOrder> packageOrders = packageOrderService.getAllPackageItems();
        return ResponseEntity.status(HttpStatus.OK).body(packageOrders);
    }


    @PostMapping
    public ResponseEntity createAPackageOrder(@RequestBody PackageOrder packageOrder){
        packageOrderService.addParkingLot(packageOrder);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity putAPackageOrder(@PathVariable String id,@RequestBody PackageOrder order){

        PackageOrder packageOrder = packageOrderService.updateAPackageOrder(id,order);
        return ResponseEntity.status(HttpStatus.OK).body(packageOrder);

    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteAPackageOrder(@PathVariable String id){
        packageOrderService.deleteAPackageOrder(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
