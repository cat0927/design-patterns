package designpattern.mediator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * DATE 2019-09-01 ES 具体同事类
 * 
 *
 */
public class EsDatabase extends AbstractDatabase {

	private List<String> dataset = new CopyOnWriteArrayList<String>();

	public EsDatabase(AbstractMediator mediator) {
		super(mediator);
	}

	@Override
	public void addData(String data) {
		System.out.println("ES 添加数据：" + data);
		this.dataset.add(data);
	}

	@Override
	public void add(String data) {
		addData(data);
		// 数据同步作业交给中介者管理
		this.mediator.sync(AbstractDatabase.ELASTICSEARCH, data);
	}

	public void count() {
		int count = this.dataset.size();
		System.out.println("Elasticsearch 统计，目前有 " + count + " 条数据，数据：" + this.dataset.toString());
	}
}