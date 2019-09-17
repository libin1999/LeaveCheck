package com.sasu.entiy;

import java.util.List;

import com.sasu.Dao.OptUrlDao;
import com.sasu.DaoImpl.OptUrlDaoImpl;

public class Meau {
	private OptUrl node;
	private List<OptUrl> children;
	private Boolean alone;
	
	public Meau(OptUrl node) {
		this.node=node;
		OptUrlDao oul=new OptUrlDaoImpl();
		this.children=oul.getSubmMeanus(node.getId());
		if(this.children==null||this.children.isEmpty())
			this.alone=true;
		else
			this.alone=false;
	}
	
	public OptUrl getNode() {
		return node;
	}
	public void setNode(OptUrl node) {
		this.node = node;
	}
	public List<OptUrl> getChilder() {
		return children;
	}
	public void setChilder(List<OptUrl> children) {
		this.children = children;
	}
	public Boolean getAlone() {
		return alone;
	}
	public void setAlone(Boolean alone) {
		this.alone = alone;
	}
	
}
