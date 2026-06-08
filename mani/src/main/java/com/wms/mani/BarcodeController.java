package com.wms.mani;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/barcode")
public class BarcodeController {

    @Autowired
    private BarcodeService barcodeService;

    @GetMapping(value = "/{sku}",
            produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getBarcode(
            @PathVariable String sku) throws Exception {

        byte[] qrCode = barcodeService.generateQRCode(sku);
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(qrCode);
    }
}