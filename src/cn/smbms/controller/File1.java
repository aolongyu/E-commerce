package cn.smbms.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class File1{
	@RequestMapping(value = "/upImage", method = RequestMethod.POST)
	@ResponseBody
	public String execute(@RequestParam(value = "scan", required = false) MultipartFile file,
			HttpServletRequest request) {
		String message = null;
		// ("/upload")鏄〃绀烘枃浠朵笂浼犲悗鐨勭洰鏍囨枃浠�
		String path = "D:\\compiler\\eclipse-workspace\\experiment_14-15\\WebContent\\statics\\images\\logo";
		// 鑾峰彇鏂囦欢鍚嶇О
		System.out.println(file);
		String fileFileName = UUID.randomUUID().toString()+file.getOriginalFilename();
		try {
			//File f = new File(path + "/" + fileFileName);
			File dir = new File(path,fileFileName);
			if (!dir.exists()) { // 濡傛灉dir浠ｈ〃鐨勬枃浠朵笉瀛樺湪锛屽垯鍒涘缓
				dir.mkdir();
			}
			// 濡傛灉瀛樺湪灏辨墽琛屼笅闈㈡搷浣�
			file.transferTo(dir);// 灏嗕笂浼犵殑瀹炰綋鏂囦欢澶嶅埗鍒板埗瀹氱洰褰晆pload涓�
		} catch (Exception e) {
			e.printStackTrace();
			message = "涓婁紶寮傚父!!!!";
			return message;
		}
		return fileFileName;
	}
}