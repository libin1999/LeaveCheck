package test;

import java.util.ArrayList;
import java.util.List;

import com.sasu.Dao.OptUrlDao;
import com.sasu.DaoImpl.OptUrlDaoImpl;
import com.sasu.entiy.Meau;
import com.sasu.entiy.OptUrl;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OptUrlDao dao=new OptUrlDaoImpl();
		List<OptUrl> oplist=dao.getOptUrllist();
		List<Meau> meanus=new ArrayList<>();
		System.out.println(" ‰≥ˆ≤‚ ‘");
		Meau meau=null;
		for(OptUrl opturl:oplist) {
//			Meau meau=new Meau(opturl);
//			meanus.add(meau);
			if(opturl.getId()==2) {
				meau=new Meau(opturl);
			}
		}
		System.out.println(meau.getNode().getTitle());
		if(!meau.getAlone()) {
			for(OptUrl op:meau.getChilder()) {
				System.out.println("\t"+op.getTitle());
			}
		}
//		for(Meau mea:meanus) {
//			System.out.println(mea.getNode().getTitle());
//			if(!mea.getAlone()) {
//				for(OptUrl op:mea.getChilder()) {
//					System.out.println("\t"+op.getTitle());
//				}
//			}
//		}
	}

}
