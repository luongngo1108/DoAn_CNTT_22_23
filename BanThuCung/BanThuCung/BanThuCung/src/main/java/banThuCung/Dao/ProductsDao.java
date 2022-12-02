package banThuCung.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import banThuCung.Dto.MapperProductDto;
import banThuCung.Dto.MapperProductsDto;
import banThuCung.Dto.ProductDto;
import banThuCung.Dto.ProductsDto;

@Repository
public class ProductsDao extends BaseDao {

	private StringBuffer SqlString() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("k.pro_id, k.proper_id, k.cat_id, k.sup_id, k.pro_name, k.quantity, ");
		sql.append("k.price, k.highlight, k.new_product, k.detail, k.created_at, k.updated_at, ");
		sql.append("k.img, k.petwei_id, k.color_id, k.foodwei_id, k.foodfla_id, k.materials_id, ");
		sql.append("k.cate_name, su.name AS sup_name ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("ppp.pro_id, ppp.proper_id, ppp.cat_id, ppp.sup_id, ppp.pro_name, ppp.quantity, ");
		sql.append("ppp.price, ppp.highlight, ppp.new_product, ppp.detail, ppp.created_at, ppp.updated_at, ");
		sql.append("ppp.img, ppp.petwei_id, ppp.color_id, ppp.foodwei_id, ppp.foodfla_id, ppp.materials_id, ");
		sql.append("cate.name AS cate_name ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("p.pro_id, p.proper_id, p.cat_id, p.sup_id, p.name AS pro_name, p.quantity, ");
		sql.append("p.price, p.highlight, p.new_product, p.detail, p.created_at, p.updated_at, ");
		sql.append("p.img, pp.petwei_id, pp.color_id, pp.foodwei_id, pp.foodfla_id, pp.materials_id ");
		sql.append("FROM ");
		sql.append("product AS p ");
		sql.append("INNER JOIN ");
		sql.append("properties AS pp ");
		sql.append("ON p.proper_id = pp.proper_id ");
		sql.append("GROUP BY p.pro_id, p.proper_id) AS ppp ");
		sql.append("INNER JOIN ");
		sql.append("category AS cate ");
		sql.append("ON ppp.cat_id = cate.cat_id ");
		sql.append("GROUP BY ppp.pro_id, ppp.proper_id, ppp.cat_id) AS k ");
		sql.append("INNER JOIN ");
		sql.append("supplier AS su ");
		sql.append("ON k.sup_id = su.sup_id ");

		return sql;
	}

	private String SqlProducts(boolean newProduct, boolean highLight) {
		StringBuffer  sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		if(highLight) {
			sql.append("AND k.highlight = true ");
		}
		if(newProduct) {
			sql.append("AND k.new_product = true ");
		}
		sql.append("GROUP BY k.pro_id, k.proper_id, k.cat_id ");
		//sql.append("ORDER BY RAND() ");
		if(highLight) {
			sql.append("LIMIT 9");
		}
		if(newProduct) {
			sql.append("LIMIT 12");
		}

		return sql.toString();	
	}

	private StringBuffer SqlProductsByCat_ID(String cat_id) {
		StringBuffer  sql = SqlString();
		sql.append("WHERE 1 = 1 ");
		sql.append("AND k.cat_id = \"" + cat_id + "\" ");
		sql.append("GROUP BY k.pro_id, k.proper_id, k.cat_id ");

		return sql;
	}

	private String SqlProductsPaginates(String cat_id, int start, int totalPage) {
		StringBuffer  sql = SqlProductsByCat_ID(cat_id);
		sql.append("LIMIT " + start + ", " + totalPage + " ");
		return sql.toString();
	}

	public List<ProductsDto> GetNewProducts() {
		String sql = SqlProducts(true, false); // (newProduct, highLight)
		List<ProductsDto> list = _jdbcTemplate.query(sql, new MapperProductsDto());
		return list;
	}

	public List<ProductsDto> GetHighLightProducts() {
		String sql = SqlProducts(false, true); // (newProduct, highLight)
		List<ProductsDto> list = _jdbcTemplate.query(sql, new MapperProductsDto());
		return list;
	}

	public List<ProductsDto> GetDataProductsByCat_ID(String cat_id) {
		String sql = SqlProductsByCat_ID(cat_id).toString();
		System.out.println(sql);
		List<ProductsDto> list = _jdbcTemplate.query(sql, new MapperProductsDto());
		return list;
	}

	public List<ProductsDto> GetProductsPaginates(String cat_id, int start, int totalPage) {
		StringBuffer sqlGetDataByID = SqlProductsByCat_ID(cat_id);
		List<ProductsDto> listProductsByID = _jdbcTemplate.query(sqlGetDataByID.toString(), new MapperProductsDto());
		List<ProductsDto> listProducts = new ArrayList<ProductsDto>();
		if(listProductsByID.size() > 0) {
			String sql = SqlProductsPaginates(cat_id, start, totalPage);
			listProducts = _jdbcTemplate.query(sql, new MapperProductsDto());
		}
		return listProducts;
	}

	private String SqlProductByCat_ID(String pro_id) {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("t.pro_id, t.proper_id, t.cat_id, t.sup_id, t.pro_name, t.quantity, ");
		sql.append("t.price, t.highlight, t.new_product, t.detail, t.created_at, t.updated_at, ");
		sql.append("t.img, t.petwei_id, t.color_id, t.foodwei_id, t.foodfla_id, t.materials_id, ");
		sql.append("t.cate_name, t.sup_name, t.pw_type, t.cl_type, t.fw_type, t.ff_type, ma.type AS ma_type ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("o.pro_id, o.proper_id, o.cat_id, o.sup_id, o.pro_name, o.quantity, ");
		sql.append("o.price, o.highlight, o.new_product, o.detail, o.created_at, o.updated_at, ");
		sql.append("o.img, o.petwei_id, o.color_id, o.foodwei_id, o.foodfla_id, o.materials_id, ");
		sql.append("o.cate_name, o.sup_name, o.pw_type, o.cl_type, o.fw_type, ff.type AS ff_type ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("n.pro_id, n.proper_id, n.cat_id, n.sup_id, n.pro_name, n.quantity, ");
		sql.append("n.price, n.highlight, n.new_product, n.detail, n.created_at, n.updated_at, ");
		sql.append("n.img, n.petwei_id, n.color_id, n.foodwei_id, n.foodfla_id, n.materials_id, ");
		sql.append("n.cate_name, n.sup_name, n.pw_type, n.cl_type, fw.type AS fw_type ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("m.pro_id, m.proper_id, m.cat_id, m.sup_id, m.pro_name, m.quantity, ");
		sql.append("m.price, m.highlight, m.new_product, m.detail, m.created_at, m.updated_at, ");
		sql.append("m.img, m.petwei_id, m.color_id, m.foodwei_id, m.foodfla_id, m.materials_id, ");
		sql.append("m.cate_name, m.sup_name, m.pw_type, cl.type AS cl_type ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("l.pro_id, l.proper_id, l.cat_id, l.sup_id, l.pro_name, l.quantity, ");
		sql.append("l.price, l.highlight, l.new_product, l.detail, l.created_at, l.updated_at, ");
		sql.append("l.img, l.petwei_id, l.color_id, l.foodwei_id, l.foodfla_id, l.materials_id, ");
		sql.append("l.cate_name, l.sup_name, pw.type AS pw_type ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("k.pro_id, k.proper_id, k.cat_id, k.sup_id, k.pro_name, k.quantity, ");
		sql.append("k.price, k.highlight, k.new_product, k.detail, k.created_at, k.updated_at, ");
		sql.append("k.img, k.petwei_id, k.color_id, k.foodwei_id, k.foodfla_id, k.materials_id, ");
		sql.append("k.cate_name, su.name AS sup_name ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("ppp.pro_id, ppp.proper_id, ppp.cat_id, ppp.sup_id, ppp.pro_name, ppp.quantity, ");
		sql.append("ppp.price, ppp.highlight, ppp.new_product, ppp.detail, ppp.created_at, ppp.updated_at, ");
		sql.append("ppp.img, ppp.petwei_id, ppp.color_id, ppp.foodwei_id, ppp.foodfla_id, ppp.materials_id, ");
		sql.append("cate.name AS cate_name ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("p.pro_id, p.proper_id, p.cat_id, p.sup_id, p.name AS pro_name, p.quantity, ");
		sql.append("p.price, p.highlight, p.new_product, p.detail, p.created_at, p.updated_at, ");
		sql.append("p.img, pp.petwei_id, pp.color_id, pp.foodwei_id, pp.foodfla_id, pp.materials_id ");
		sql.append("FROM ");
		sql.append("product AS p ");
		sql.append("INNER JOIN ");
		sql.append("properties AS pp ");
		sql.append("ON p.proper_id = pp.proper_id ");
		sql.append("GROUP BY p.pro_id, p.proper_id) AS ppp ");
		sql.append("INNER JOIN ");
		sql.append("category AS cate ");
		sql.append("ON ppp.cat_id = cate.cat_id ");
		sql.append("GROUP BY ppp.pro_id, ppp.proper_id, ppp.cat_id) AS k ");
		sql.append("INNER JOIN ");
		sql.append("supplier AS su ");
		sql.append("ON k.sup_id = su.sup_id ");
		sql.append("GROUP BY k.pro_id, k.proper_id, k.cat_id) AS l ");
		sql.append("LEFT OUTER JOIN ");
		sql.append("petweight AS pw ");
		sql.append("ON l.petwei_id = pw.petwei_id ");
		sql.append("GROUP BY l.pro_id, l.proper_id, l.cat_id) AS m ");
		sql.append("LEFT OUTER JOIN ");
		sql.append("color AS cl ");
		sql.append("ON m.color_id = cl.color_id ");
		sql.append("GROUP BY m.pro_id, m.proper_id, m.cat_id) AS n ");
		sql.append("LEFT OUTER JOIN ");
		sql.append("foodweight AS fw ");
		sql.append("ON n.foodwei_id = fw.foodwei_id ");
		sql.append("GROUP BY n.pro_id, n.proper_id, n.cat_id) AS o ");
		sql.append("LEFT OUTER JOIN ");
		sql.append("foodflavorings AS ff ");
		sql.append("ON o.foodfla_id = ff.foodfla_id ");
		sql.append("GROUP BY o.pro_id, o.proper_id, o.cat_id) AS t ");
		sql.append("LEFT OUTER JOIN ");
		sql.append("materials AS ma ");
		sql.append("ON t.materials_id = ma.materials_id ");
		sql.append("WHERE 1=1 ");
		sql.append("AND t.pro_id = '" + pro_id + "' ");
		sql.append("LIMIT 1");
		
		return sql.toString();
	}

	public List<ProductDto> GetProductByPro_ID(String pro_id) {
		String sql = SqlProductByCat_ID(pro_id);
		System.out.println(sql);
		List<ProductDto> listProduct = _jdbcTemplate.query(sql, new MapperProductDto());
		return listProduct;
	}

	public ProductDto FindProductByPro_ID(String pro_id) {
		String sql = SqlProductByCat_ID(pro_id);
		ProductDto product = _jdbcTemplate.queryForObject(sql, new MapperProductDto());
		return product;
	}

	//Admin part
	public List<ProductsDto> getAllProducts() {
		StringBuffer sql = SqlString();
		List<ProductsDto> products = _jdbcTemplate.query(sql.toString(), new MapperProductsDto());
		return products;
	}

	public int saveProduct(ProductsDto productsDto) {
		String sql = "Insert into product(pro_id, proper_id, cat_id, sup_id, name, quantity, price, highlight, new_product, detail, "
				+ "created_at, updated_at, img) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return _jdbcTemplate.update(sql, productsDto.getPro_id(), productsDto.getProper_id(), productsDto.getCat_id(),productsDto.getSup_id(),
				productsDto.getPro_name(),productsDto.getQuantity(),productsDto.getPrice(), productsDto.getHighlight(),
				productsDto.getNew_product(), productsDto.getDetail(), productsDto.getCreated_at(), productsDto.getUpdated_at(), productsDto.getImg());
	}

	public int updateProduct(ProductsDto productsDto) {
		String sql = "Update product set cat_id=?, sup_id=?, name=?, quantity=?, price=?, highlight=?, new_product=?, detail=?"
				+ ", created_at=?, updated_at=?, img=? where pro_id=? AND proper_id=?";
		return _jdbcTemplate.update(sql,productsDto.getCat_id(),productsDto.getSup_id(),
				productsDto.getPro_name(),productsDto.getQuantity(),productsDto.getPrice(), productsDto.getHighlight(),
				productsDto.getNew_product(), productsDto.getDetail(), productsDto.getCreated_at(), productsDto.getUpdated_at(),
				productsDto.getImg(),productsDto.getPro_id(), productsDto.getProper_id());
	}

	public ProductsDto getProductsDtoByID(String pro_id, String proper_id) {
		StringBuffer sql = SqlString();
		sql.append("WHERE k.pro_id = ? and k.proper_id = ?");
		return _jdbcTemplate.queryForObject(sql.toString(), new MapperProductsDto(),pro_id, proper_id);
	}

	public int deleteProduct(String pro_id, String proper_id) {
		String sql = "Delete from product where pro_id=? and proper_id=?";
		return _jdbcTemplate.update(sql, pro_id, proper_id);
	}

	public List<ProductsDto> getBestSold() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT ");
		sql.append("k.pro_id, k.proper_id, k.cat_id, k.sup_id, k.pro_name, SUM(od.quantity) as quantity, ");
		sql.append("k.price, k.highlight, k.new_product, k.detail, k.created_at, k.updated_at, ");
		sql.append("k.img, k.petwei_id, k.color_id, k.foodwei_id, k.foodfla_id, k.materials_id, ");
		sql.append("k.cate_name, su.name AS sup_name ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("ppp.pro_id, ppp.proper_id, ppp.cat_id, ppp.sup_id, ppp.pro_name, ppp.quantity, ");
		sql.append("ppp.price, ppp.highlight, ppp.new_product, ppp.detail, ppp.created_at, ppp.updated_at, ");
		sql.append("ppp.img, ppp.petwei_id, ppp.color_id, ppp.foodwei_id, ppp.foodfla_id, ppp.materials_id, ");
		sql.append("cate.name AS cate_name ");
		sql.append("FROM ");
		sql.append("(SELECT ");
		sql.append("p.pro_id, p.proper_id, p.cat_id, p.sup_id, p.name AS pro_name, p.quantity, ");
		sql.append("p.price, p.highlight, p.new_product, p.detail, p.created_at, p.updated_at, ");
		sql.append("p.img, pp.petwei_id, pp.color_id, pp.foodwei_id, pp.foodfla_id, pp.materials_id ");
		sql.append("FROM ");
		sql.append("product AS p ");
		sql.append("INNER JOIN ");
		sql.append("properties AS pp ");
		sql.append("ON p.proper_id = pp.proper_id ");
		sql.append("GROUP BY p.pro_id, p.proper_id) AS ppp ");
		sql.append("INNER JOIN ");
		sql.append("category AS cate ");
		sql.append("ON ppp.cat_id = cate.cat_id ");
		sql.append("GROUP BY ppp.pro_id, ppp.proper_id, ppp.cat_id) AS k ");
		sql.append("INNER JOIN ");
		sql.append("supplier AS su ");
		sql.append("ON k.sup_id = su.sup_id ");
		sql.append("INNER JOIN order_detail AS od ");
		sql.append("ON od.pro_id = k.pro_id AND od.proper_id = k.proper_id ");
		sql.append("GROUP BY od.pro_id, proper_id ");

		List<ProductsDto> products = _jdbcTemplate.query(sql.toString(), new MapperProductsDto());
		return products;
	}
}
