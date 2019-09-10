package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.entities.Dept;
import springcloud.service.DeptClientService;

import java.util.List;

@RestController
public class DeptController_Consumer
{

//	private static final String REST_URL_PREFIX = "http://localhost:8001";
//	private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPTS";

	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
//	@Autowired
//	private RestTemplate restTemplate;
    @Autowired
    private DeptClientService service;

	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept)
	{
//		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
		return service.add(dept);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return service.get(id);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list()
	{
		return service.list();
	}

}
