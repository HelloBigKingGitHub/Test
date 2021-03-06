package com.hl.service;

import java.util.List;

import com.hl.entity.RPostBar;
import com.hl.entity.Userinfo;

/**
 * 
 * <p>Title: RPostBarService</p>  
 * <p>Description: 回帖的服务层接口</p>  
 * @author huangliang 
 * @date 2019年4月24日
 */
public interface RPostBarService {
	/**
	 * 注意事项，一个帖子可以有多个回复，子不能回复自己发的帖子
	 * 
	 */
	
	
	/**
	 * 
	 * <p>Title: showRPostBarByPbid</p>  
	 * <p>Description: 根据帖子的id展示所有的回复帖子</p> 
	 * <p>data:2019年4月27日 下午5:39:26 </p> 
	 * @param pbid
	 * @return
	 */
	List<RPostBar> showRPostBarByPbid(String pbid);

	/**
	 * 
	 * <p>Title: receivePostBar</p>  
	 * <p>Description: 回复指定的帖子</p> 
	 * <p>data:2019年5月2日 下午2:07:01 </p> 
	 * @param pbid
	 * @param rquescontent
	 * @param user
	 * @return
	 */
	boolean receivePostBar(String pbid, String rquescontent, Userinfo user);
}
