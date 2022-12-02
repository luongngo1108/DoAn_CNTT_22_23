package banThuCung.adminController;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import banThuCung.Dto.ProductsDto;
import banThuCung.adminService.CategoryServcieImpAd;
import banThuCung.adminService.ProductServiceImpAd;
import banThuCung.adminService.PropertyServiceImp;
import banThuCung.adminService.SupplierServcieImp;

@Controller
@RequestMapping(value = "/quan-tri/san-pham/cac-san-pham")
public class ProductControllerAd {
	private static final String UPLOAD_DIRECTORY ="C:/Users/HOANG/Downloads/BanThuCung/BanThuCung/src/main/webapp/assets/user/img/products"; 

	@Autowired
	ProductServiceImpAd productService = new ProductServiceImpAd();

	@Autowired
	PropertyServiceImp propertyService = new PropertyServiceImp();

	@Autowired
	CategoryServcieImpAd categoryServcie = new CategoryServcieImpAd();

	@Autowired
	SupplierServcieImp supplierServcie = new SupplierServcieImp();

	@RequestMapping("/productForm")    
	public ModelAndView showform(HttpSession session, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}

		mv.addObject("product", new ProductsDto());
		mv.addObject("properList", propertyService.getAllProperties());
		mv.addObject("supList", supplierServcie.getAllSuppliers());
		mv.addObject("catList", categoryServcie.getAllCategories());
		session.setAttribute("errorDelProductMessage", null);
		mv.setViewName("admin/ProductForm");

		return mv;   
	} 

	@RequestMapping( value="/update",method = RequestMethod.POST)    
	public ModelAndView save(HttpSession session, ModelAndView mv, @ModelAttribute("product") ProductsDto productsDto){  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}

		try {
			productService.updateProduct(productsDto);
			mv.setViewName("redirect:/quan-tri/san-pham/cac-san-pham/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.addObject("properList", propertyService.getAllProperties());
			mv.addObject("supList", supplierServcie.getAllSuppliers());
			mv.addObject("catList", categoryServcie.getAllCategories());
			mv.setViewName("admin/ProductForm");
		}  
		return mv;    
	} 

	@RequestMapping(value = "/delete/{pro_id}/{proper_id}") 
	public ModelAndView delete(HttpSession session, @PathVariable String pro_id,@PathVariable String proper_id, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}

		try {
			productService.deleteProduct(pro_id,proper_id);	
			session.setAttribute("errorDelProductMessage", null);
		} catch (Exception e) {
			String errorString = "Không thể xóa Pro_ID: " +pro_id+", Proper_ID: " +proper_id + " vì sẽ ảnh hưởng tới các bảng khác";
			session.setAttribute("errorDelProductMessage", errorString);
		}

		mv.setViewName("redirect:/quan-tri/san-pham/cac-san-pham/list");
		return mv;
	}

	@RequestMapping(value = "/list")
	public ModelAndView list(HttpSession session, ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}
		
		List<ProductsDto> productList =  productService.getAllProducts(); 
		mv.addObject("productList", productList);
		mv.setViewName("admin/ProductList");
		return mv;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST) 
	public ModelAndView create(HttpSession session, @ModelAttribute("product") ProductsDto productsDto,ModelAndView mv) {
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}

		try {
			productService.createProduct(productsDto);
			mv.setViewName("redirect:/quan-tri/san-pham/cac-san-pham/list");
		} catch (Exception e) {
			mv.addObject("error","Lỗi! Vui lòng kiểm tra lại dữ liệu truyền vào!!!");
			mv.addObject("properList", propertyService.getAllProperties());
			mv.addObject("supList", supplierServcie.getAllSuppliers());
			mv.addObject("catList", categoryServcie.getAllCategories());
			productsDto.setPro_id(null);
			productsDto.setProper_id(null);
			mv.addObject("product", productsDto);
			mv.setViewName("admin/ProductForm");
		}  
		return mv;
	}

	@RequestMapping(value="/edit/{pro_id}/{proper_id}")    
	public ModelAndView edit(HttpSession session, @PathVariable String pro_id,@PathVariable String proper_id, ModelAndView mv){    
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}

		ProductsDto productsDto=productService.getProductByID(pro_id, proper_id); 
		session.setAttribute("errorDelProductMessage", null);
		mv.addObject("product", productsDto);
		mv.addObject("properList", propertyService.getAllProperties());
		mv.addObject("supList", supplierServcie.getAllSuppliers());
		mv.addObject("catList", categoryServcie.getAllCategories());
		mv.setViewName("admin/ProductForm");
		return mv;    
	}  

	@RequestMapping(value="/savefile",method=RequestMethod.POST)  
	public ModelAndView saveimage( @RequestParam CommonsMultipartFile file,  
			HttpSession session, ModelAndView mv) throws Exception{  
		if((String)session.getAttribute("trueLogin") != "yes")  {
			mv.setViewName("redirect:/quan-tri/dang-nhap");
			return mv;
		}

		String path = UPLOAD_DIRECTORY;  
		String filename = file.getOriginalFilename();  

		System.out.println(path+" "+filename);        

		byte[] bytes = file.getBytes();  
		BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
				new File(path + File.separator + filename)));  
		stream.write(bytes);  
		stream.flush();  
		stream.close();  
		
		mv.setViewName("admin/ProductList");
		List<ProductsDto> productList =  productService.getAllProducts(); 
		mv.addObject("productList", productList);
		mv.addObject("filesuccess", "Đã up ảnh thành công!");
		return mv;  
	}  
}
