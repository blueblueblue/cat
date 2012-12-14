package com.dianping.cat.report.page.logview;

import java.util.Collection;
import java.util.Collections;

import com.dianping.cat.report.page.AbstractReportModel;

public class Model extends AbstractReportModel<Action, Context> {
	private String m_domain;

	private String m_mobileResponse;

	private String m_table;
	
	private String m_logviewPath;

	public Model(Context ctx) {
		super(ctx);
	}

	@Override
	public Action getDefaultAction() {
		return Action.VIEW;
	}

	@Override
	public String getDomain() {
		return m_domain;
	}

	@Override
	public Collection<String> getDomains() {
		return Collections.emptySet();
	}

	public String getMobileResponse() {
		return m_mobileResponse;
	}

	public String getTable() {
		return m_table;
	}

	public void setDomain(String domain) {
		m_domain = domain;
	}

	public void setMobileResponse(String mobileResponse) {
		m_mobileResponse = mobileResponse;
	}

	public void setTable(String table) {
		m_table = table;
	}

	public String getLogviewPath() {
		return m_logviewPath;
	}

	public void setLogviewPath(String logviewPath) {
		m_logviewPath = logviewPath;
	}
	
}