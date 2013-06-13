package com.dianping.abtest.sample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dianping.cat.abtest.ABTest;
import com.dianping.cat.abtest.ABTestName;
import com.dianping.cat.abtest.ABTestManager;

public class ABTestSampleServlet extends HttpServlet {
	private static final long serialVersionUID = -6472784609174835547L;

	private ABTest m_abtest = ABTestManager.getTest(MyABTestId.CASE1);

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (m_abtest.isGroupA()) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index1.jsp");
			rd.forward(request, response);
			// Cat.logMetric(...);
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index2.jsp");
			rd.forward(request, response);
			// Cat.logMetric(...);
		}
	}

	public static enum MyABTestId implements ABTestName {
		CASE1("demo1");

		private String m_id;

		private MyABTestId(String id) {
			m_id = id;
		}

		@Override
		public String getValue() {
			return m_id;
		}
	}
}