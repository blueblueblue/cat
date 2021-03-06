package com.dianping.cat.report.task.problem;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.unidal.webres.helper.Files;

import com.dianping.cat.consumer.problem.ProblemAnalyzer;
import com.dianping.cat.consumer.problem.model.entity.ProblemReport;
import com.dianping.cat.consumer.problem.model.transform.DefaultSaxParser;
import com.dianping.cat.core.dal.Graph;

public class ProblemCreateGraphDataTest {

	@Test
	public void testGraph() throws Exception {
		String newXml = Files.forIO().readFrom(getClass().getResourceAsStream("problemModel.xml"), "utf-8");
		ProblemReport report = DefaultSaxParser.parse(newXml);

		ProblemGraphCreator creator = new ProblemGraphCreator();
		List<Graph> graphs = creator.splitReportToGraphs(report.getStartTime(), "Cat", ProblemAnalyzer.ID, report);

		Assert.assertEquals("The graphs size", 3, graphs.size());

		Graph graph = graphs.get(0);

		String detail = graph.getDetailContent();
		String summary = graph.getSummaryContent();

		String exceptionSummary = Files.forIO().readFrom(getClass().getResourceAsStream("problemSummary"), "utf-8");
		String exceptionDetail = Files.forIO().readFrom(getClass().getResourceAsStream("problemDetail"), "utf-8");

		Assert.assertEquals(exceptionSummary.replaceAll("\r", ""), summary.replaceAll("\r", ""));
		Assert.assertEquals(exceptionDetail.replaceAll("\r", ""), detail.replaceAll("\r", ""));

		graph = graphs.get(1);

		detail = graph.getDetailContent();
		summary = graph.getSummaryContent();

		Assert.assertEquals(exceptionSummary.replaceAll("\r", ""), summary.replaceAll("\r", ""));
		Assert.assertEquals(exceptionDetail.replaceAll("\r", ""), detail.replaceAll("\r", ""));

		exceptionSummary = Files.forIO().readFrom(getClass().getResourceAsStream("problemAllSummary"), "utf-8");
		exceptionDetail = Files.forIO().readFrom(getClass().getResourceAsStream("problemAllDetail"), "utf-8");
		graph = graphs.get(2);

		detail = graph.getDetailContent();
		summary = graph.getSummaryContent();

		Assert.assertEquals(exceptionSummary.replaceAll("\r", ""), summary.replaceAll("\r", ""));
		Assert.assertEquals(exceptionDetail.replaceAll("\r", ""), detail.replaceAll("\r", ""));
	}
}
