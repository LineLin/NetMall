package com.line.web.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.line.web.model.Plate;

@Repository("plateDao")
@SuppressWarnings("unchecked")
public class PlateDaoImpl extends BasicDaoImpl<Plate> implements PlateDao {

	/**
	 * 功能：得到某板块下{count}个按展示级别升序的板块,如果pPlate为null，那么返回一级板块,
	 * 		如果count == Integer.MAX_VALUE的话，那么返回符合条件的所有结果。
	 * @param pPlate 父板块
	 * @param count 取得的板块数
	 */
	@Override
	public List<Plate> getPlateOrderByShowSeq(String pid,int count) {
		
		String hql;
		if(pid == null){
			hql = "select p from Plate p where p.level = 1 order by p.showSeq";
		}else{
			hql = "select p from Plate p where p.parentPlate ='" + pid
					+"' order by p.showSeq";
		}
		
		return getSession().createQuery(hql)
				 .setFirstResult(0)
				 .setMaxResults(count)
				 .list();
	}
//	
//	@Override
//	public void save(Plate plate){
//		getSession().save(plate);
//	}
//	
//	@Override
//	public void del(String plateId){
//		Session session = getSession();
//		Plate plate = (Plate) session.get(Plate.class,plateId);
//		session.delete(plate);
//	}
//	
//	@Override
//	public void update(Plate plate){
//		getSession().update(plate);
//	}
	
	@Override
	public Plate getById(String id) {
		return (Plate) getSession().get(Plate.class,id);
	}
	
	/**
	 * 功能：获得某个板块parent下的直接子板块，直接子板块即以parent为根的树的下一层结点。
	 * @param parent 父板块
	 */
	@Override
	public List<Plate> getByPid(Plate parent) {
		return getSession()
				.createQuery("select p from Plate p where p.parentPlate =:parent")
				.setParameter("parent",parent)
				.list();
	}
	
	@Override
	public List<Plate> getByPid(String parentId) {
		return getByPid(getById(parentId));
	}

	@Override
	public List<Plate> getByLevel(int level) {
		return getSession().createQuery("select p from Plate p where p.level =:level")
				.setParameter("level",level)
				.list();
	}
	
	/**
	 * 功能：得到某板块plate下的最底层板块，即以板块plate为根的树的叶子结点
	 * @param plate 
	 */
	@Override
	public List<Plate> getLeafPlate(Plate plate) {
		return getSession().createQuery("select p from Plate p where p.path like :pid")
				.setParameter("pid", "%" + plate.getId() + "%")
				.list();
	}
	
}
