package gg.jte.generated.ondemand.history;
import web.app.controllers.history.SearchHistoryPage;
public final class Jtesearch_historyGenerated {
	public static final String JTE_NAME = "history/search_history.jte";
	public static final int[] JTE_LINE_INFO = {0,0,2,2,2,4,4,4,4,9,9,11,11,13,13,14,14,16,16,19,19,19,20,20,20,21,21,21,22,22,22,22,22,22,22,28,28,30,30,32,32,36,36,39,39,42,42,43,43,43,43,43,43,43,43,43,43,43,43,43,43,44,44,46,46,46,47,47,47,48,48,48,48,48,48,48,50,50,52,52,52,54,54,57,57,60,60,62,62,62};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, SearchHistoryPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtebaseGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<div class=\"container-fluid mt-5\">\r\n    <div class=\"row\">\r\n        <div class=\"col-sm-4\"></div>\r\n        <div class=\"col-sm-4\">\r\n        \t");
				if (page.articles == null) {
					jteOutput.writeContent("\r\n            \t<h2 class=\"search-title-history\">Search History</h2>\r\n            ");
				} else {
					jteOutput.writeContent("\r\n            \t<h2 class=\"search-title-history\">Results</h2>\r\n            ");
				}
				jteOutput.writeContent("\r\n            ");
				if (page.history != null) {
					jteOutput.writeContent("\r\n            <ul class=\"list-group list-group-flush\">\r\n            \t");
					for (var h: page.history) {
						jteOutput.writeContent("\r\n\t                <li class=\"list-group-item\">\r\n\t                    <form method=\"POST\" action=\"/fetch_from_history\" class=\"form\">\r\n\t                        <p>");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(h.getDesc());
						jteOutput.writeContent("</p>\r\n\t                        <p><i class=\"bi bi-calendar\"></i> ");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(h.getDateTime().toString().substring(0,10));
						jteOutput.writeContent("</p>\r\n\t                        <p><i class=\"bi bi-clock\"></i> ");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(h.getDateTime().toString().substring(11,16));
						jteOutput.writeContent("</p>\r\n\t                        <input type=\"hidden\" name=\"id\"");
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(h.getId())) {
							jteOutput.writeContent(" value=\"");
							jteOutput.setContext("input", "value");
							jteOutput.writeUserContent(h.getId());
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(" />\r\n\t                        <div class=\"text-center\">\r\n\t                            <button type=\"submit\" class=\"btn btn-sm btn-submit\">Search</button>\r\n\t                        </div>\r\n\t                    </form>\r\n\t                </li>\r\n                ");
					}
					jteOutput.writeContent("\r\n            </ul>\r\n            ");
				} else {
					jteOutput.writeContent(" \r\n            \t<p class=\"not-history-paragraph\">Nothing has been searched...</p>\r\n            ");
				}
				jteOutput.writeContent("\r\n        </div>\r\n        <div class=\"col-sm-4\"></div>\r\n    </div>\r\n    ");
				if (page.articles != null) {
					jteOutput.writeContent(" \r\n       <div class=\"container-fluid\">\r\n           <div class=\"row\">\r\n            ");
					for (var article : page.articles) {
						jteOutput.writeContent("\r\n\t\t        <div class=\"col-sm-4 mt-3\">\r\n\t\t            <div class=\"card\">\r\n\t\t            \t");
						if (article.getUrlToImage() != null) {
							jteOutput.writeContent("\r\n\t\t                \t<img");
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(article.getUrlToImage())) {
								jteOutput.writeContent(" src=\"");
								jteOutput.setContext("img", "src");
								jteOutput.writeUserContent(article.getUrlToImage());
								jteOutput.writeContent("\"");
							}
							jteOutput.writeContent(" class=\"card-img-top\"");
							if (gg.jte.runtime.TemplateUtils.isAttributeRendered(article.getTitle())) {
								jteOutput.writeContent(" alt=\"");
								jteOutput.setContext("img", "alt");
								jteOutput.writeUserContent(article.getTitle());
								jteOutput.writeContent("\"");
							}
							jteOutput.writeContent(">\r\n\t\t                ");
						}
						jteOutput.writeContent("\r\n\t\t                <div class=\"card-body\">\r\n\t\t                    <h5 class=\"card-title\">");
						jteOutput.setContext("h5", null);
						jteOutput.writeUserContent(article.getTitle());
						jteOutput.writeContent("</h5>\r\n\t\t                    <p class=\"card-text\">");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(article.getDescription());
						jteOutput.writeContent("</p>\r\n\t\t                    <a");
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(article.getUrl())) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(article.getUrl());
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(" class=\"btn btn-primary\">See more...</a>\r\n\t\t                </div>\r\n\t\t                ");
						if (article.getPublishedAt() != null) {
							jteOutput.writeContent("\r\n\t\t\t                <div class=\"card-footer text-muted\">\r\n\t\t\t                  ");
							jteOutput.setContext("div", null);
							jteOutput.writeUserContent(article.getPublishedAt().toString());
							jteOutput.writeContent("\r\n\t\t\t                </div>\r\n\t\t\t            ");
						}
						jteOutput.writeContent("\r\n\t\t            </div>\r\n\t\t        </div>\r\n\t\t    ");
					}
					jteOutput.writeContent("\r\n\t\t  </div>\r\n\t\t</div>\r\n     ");
				}
				jteOutput.writeContent("\r\n</div>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		SearchHistoryPage page = (SearchHistoryPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
