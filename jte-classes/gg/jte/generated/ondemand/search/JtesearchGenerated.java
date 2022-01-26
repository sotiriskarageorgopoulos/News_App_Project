package gg.jte.generated.ondemand.search;
import web.app.controllers.search.SearchPage;
import kar.sot.util.Article;
public final class JtesearchGenerated {
	public static final String JTE_NAME = "search/search.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,6,6,6,6,23,23,24,24,24,24,24,24,24,24,24,24,25,25,46,46,47,47,47,47,47,47,47,47,47,47,48,48,71,71,72,72,75,75,76,76,76,76,76,76,76,76,76,76,76,76,76,76,77,77,79,79,79,80,80,80,81,81,81,81,81,81,81,84,84,84,88,88,89,89,92,92,92};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, SearchPage page, Article article) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtebaseGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\t\r\n    <div class=\"container-fluid mt-5\">\r\n        <div class=\"row\">\r\n            <div class=\"col-sm-2\">\r\n                <form method=\"POST\" action=\"/search_by_source\">\r\n                    <label for=\"source\" class=\"label-form select-label mb-2\">Search By Source</label>\r\n                    <input name=\"source\" id=\"source\" class=\"select-input\" />\r\n                    <div class=\"text-center mt-3\">\r\n                        <button type=\"submit\" class=\"btn btn-sm btn-submit\">Submit</button>\r\n                    </div>\r\n                </form>\r\n            </div>\r\n            <div class=\"col-sm-2\">\r\n                <form method=\"POST\" action=\"/search_by_lang\">\r\n                    <label for=\"lang\" class=\"label-form select-label mb-2\">Search By Language</label>\r\n                    <select name=\"lang\" id=\"lang\" class=\"select-input\">\r\n                        <option>Select...</option>\r\n                        ");
				for (var l: page.langs) {
					jteOutput.writeContent("\r\n                          <option");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(l.getLanguage())) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(l.getLanguage());
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(l.getLanguage());
					jteOutput.writeContent("</option>\r\n                        ");
				}
				jteOutput.writeContent("\r\n                    </select>\r\n                    <div class=\"text-center mt-3\">\r\n                        <button type=\"submit\" class=\"btn btn-sm btn-submit\">Submit</button>\r\n                    </div>\r\n                </form>\r\n            </div>\r\n            <div class=\"col-sm-4\">\r\n                <form method=\"POST\" action=\"/search_by_term\">\r\n                    <label class=\"label-form input-label mb-2\" for=\"term\">Search by a term</label>\r\n                    <input type=\"text\" id=\"term\" name=\"term\" class=\"input-style\" />\r\n                    <div class=\"text-center mt-3\">\r\n                        <button type=\"submit\" class=\"btn btn-sm btn-submit\">Submit</button>\r\n                    </div>\r\n                </form>\r\n            </div>\r\n            <div class=\"col-sm-2\">\r\n                <form method=\"POST\" action=\"/search_by_category\">\r\n                    <label for=\"category\" class=\"label-form select-label mb-2\">Search By Category</label>\r\n                    <select name=\"category\"  id=\"category\" class=\"select-input\">\r\n                        <option>Select...</option>\r\n                        ");
				for (var c: page.categories) {
					jteOutput.writeContent("\r\n                        \t<option");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(c)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(c);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(c);
					jteOutput.writeContent("</option>\r\n                        ");
				}
				jteOutput.writeContent("\r\n                    </select>\r\n                    <div class=\"text-center mt-3\">\r\n                        <button type=\"submit\" class=\"btn btn-sm btn-submit\">Submit</button>\r\n                    </div>\r\n                </form>\r\n            </div>\r\n            <div class=\"col-sm-2\">\r\n                <form method=\"POST\" action=\"/search_by_time_period\">\r\n                    <h4 class=\"search-title\">Search By Time</h4>\r\n                    <label class=\"label-form select-label mb-2\">Term</label>\r\n                \t<input type=\"text\" class=\"input-style\" name=\"term\" />\r\n                    <label class=\"label-form input-label mb-2\" for=\"from_date\">From</label>\r\n                    <input type=\"datetime-local\" id=\"from_date\" name=\"from_date\" class=\"input-style\" />\r\n                    <label class=\"label-form input-label mb-2\" for=\"to_date\">To</label>\r\n                    <input type=\"datetime-local\" id=\"to_date\" name=\"to_date\" class=\"input-style\" />\r\n                    <div class=\"text-center mt-3\">\r\n                        <button type=\"submit\" class=\"btn btn-sm btn-submit\">Submit</button>\r\n                    </div>\r\n                </form>\r\n            </div>\r\n        </div>\r\n        <div class=\"row mt-5\">\r\n            ");
				if (page.articles != null) {
					jteOutput.writeContent("\r\n            \t ");
					for (Article article : page.articles) {
						jteOutput.writeContent("\r\n\t\t\t        <div class=\"col-sm-4\">\r\n\t\t\t            <div class=\"card\">\r\n\t\t\t            \t");
						if (article.getUrlToImage() != null) {
							jteOutput.writeContent("\r\n\t\t\t                \t<img");
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
							jteOutput.writeContent(">\r\n\t\t\t                ");
						}
						jteOutput.writeContent("\r\n\t\t\t                <div class=\"card-body\">\r\n\t\t\t                    <h5 class=\"card-title\">");
						jteOutput.setContext("h5", null);
						jteOutput.writeUserContent(article.getTitle());
						jteOutput.writeContent("</h5>\r\n\t\t\t                    <p class=\"card-text\">");
						jteOutput.setContext("p", null);
						jteOutput.writeUserContent(article.getDescription());
						jteOutput.writeContent("</p>\r\n\t\t\t                    <a");
						if (gg.jte.runtime.TemplateUtils.isAttributeRendered(article.getUrl())) {
							jteOutput.writeContent(" href=\"");
							jteOutput.setContext("a", "href");
							jteOutput.writeUserContent(article.getUrl());
							jteOutput.writeContent("\"");
						}
						jteOutput.writeContent(" class=\"btn btn-primary\">See more...</a>\r\n\t\t\t                </div>\r\n\t\t\t                <div class=\"card-footer text-muted\">\r\n\t\t\t                  ");
						jteOutput.setContext("div", null);
						jteOutput.writeUserContent(article.getPublishedAt() != null? "Published:\t"+article.getPublishedAt().toString(): "");
						jteOutput.writeContent("\r\n\t\t\t                </div>\r\n\t\t\t            </div>\r\n\t\t\t        </div>\r\n\t\t\t     ");
					}
					jteOutput.writeContent("\r\n            ");
				}
				jteOutput.writeContent("\r\n        </div>\r\n    </div>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		SearchPage page = (SearchPage)params.get("page");
		Article article = (Article)params.get("article");
		render(jteOutput, jteHtmlInterceptor, page, article);
	}
}
