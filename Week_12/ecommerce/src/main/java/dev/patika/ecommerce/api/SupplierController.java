package dev.patika.ecommerce.api;

import dev.patika.ecommerce.business.abstracts.ISupplierService;
import dev.patika.ecommerce.business.concretes.SupplierManager;
import dev.patika.ecommerce.core.config.modelMapper.IModelMapperService;
import dev.patika.ecommerce.core.result.Result;
import dev.patika.ecommerce.core.result.ResultData;
import dev.patika.ecommerce.core.utilies.ResultHelper;
import dev.patika.ecommerce.dto.request.category.CategorySaveRequest;
import dev.patika.ecommerce.dto.request.supplier.SupplierSaveRequest;
import dev.patika.ecommerce.dto.request.supplier.SupplierUpdateRequest;
import dev.patika.ecommerce.dto.response.CursorResponse;
import dev.patika.ecommerce.dto.response.category.CategoryResponse;
import dev.patika.ecommerce.dto.response.suppliers.SupplierResponse;
import dev.patika.ecommerce.entities.Category;
import dev.patika.ecommerce.entities.Supplier;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/suppliers")
public class SupplierController {
    private final ISupplierService supplierService;
    private final IModelMapperService mapperService;

    public SupplierController(ISupplierService supplierService, IModelMapperService mapperService) {
        this.supplierService = supplierService;
        this.mapperService = mapperService;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<SupplierResponse> save(@Valid @RequestBody SupplierSaveRequest supplierSaveRequest) {
        Supplier saveRequest=this.mapperService.forRequest().map(supplierSaveRequest,Supplier.class);
        this.supplierService.save(saveRequest);
        return ResultHelper.created(this.mapperService.forResponse().map(saveRequest,SupplierResponse.class));
        }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> update(@Valid @RequestBody SupplierUpdateRequest supplierUpdateRequest) {
        Supplier updateSupplier = this.mapperService.forRequest().map(supplierUpdateRequest, Supplier.class);
        this.supplierService.update(updateSupplier);
        return ResultHelper.success(this.mapperService.forResponse().map(updateSupplier, SupplierResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<SupplierResponse> get(@PathVariable("id") int id){
        Supplier supplier= this.supplierService.get(id);
        SupplierResponse supplierResponse = this.mapperService.forResponse().map(supplier,SupplierResponse.class);
        return ResultHelper.success(supplierResponse);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<SupplierResponse>> cursor(
            @RequestParam(name = "page",required = false,defaultValue = "0") int page,
            @RequestParam(name = "pageSize",required = false,defaultValue = "10") int pageSize
    ){
        Page<Supplier> supplierPage=this.supplierService.cursor(page,pageSize);
        Page<SupplierResponse> supplierResponsePage= supplierPage
                .map(supplier -> this.mapperService.forResponse().map(supplier,SupplierResponse.class));
        return ResultHelper.cursor(supplierResponsePage);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.supplierService.delete(id);
        return ResultHelper.ok();
    }
}
