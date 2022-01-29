package gg.jte.generated.ondemand.index;
import web.app.controllers.index.IndexPage;
import kar.sot.util.Article;
public final class JteindexGenerated {
	public static final String JTE_NAME = "index/index.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,5,5,5,5,15,15,16,16,16,16,16,16,16,16,16,16,17,17,29,29,30,30,30,30,30,30,30,30,30,30,31,31,42,42,45,45,46,46,46,46,46,46,46,46,46,46,46,46,46,46,47,47,49,49,49,50,50,50,51,51,51,51,51,51,51,53,53,55,55,55,55,55,55,57,57,60,60,63,63,63};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, IndexPage page) {
		jteOutput.writeContent("\r\n");
		gg.jte.generated.ondemand.layout.JtebaseGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\r\n<div class=\"container-fluid mt-5\">\r\n    <h2 class=\"top-headlines mt-5\">Top Headlines</h2>\r\n    <div class=\"row\">\r\n        <div class=\"col-sm-4\"></div>\r\n        <div class=\"col-sm-2\">\r\n            <form method=\"POST\" class=\"form\" action=\"/fetch_by_country\">\r\n                <label for=\"country\" class=\"form-label select-label\">Change country</label>\r\n                <select id=\"country\" name=\"country\" class=\"select-input\">\r\n                    <option>Select...</option>\r\n                    ");
				for (var c : page.allCountries) {
					jteOutput.writeContent("\r\n                      <option");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(c.getCountry())) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(c.getCountry());
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(c.getCountry());
					jteOutput.writeContent("</option>\r\n                    ");
				}
				jteOutput.writeContent("\r\n                </select>\r\n                <div class=\"text-center\">\r\n                    <button type=\"submit\" class=\"btn btn-sm mt-3 btn-submit\">Submit</button>\r\n                </div>\r\n            </form>\r\n        </div>\r\n        <div class=\"col-sm-2\">\r\n            <form method=\"POST\" class=\"form\" action=\"/fetch_by_category\">\r\n                <label for=\"category\" class=\"form-label select-label\">Change category</label>\r\n                <select id=\"category\" name=\"category\" class=\"select-input\">\r\n                    <option>Select...</option>\r\n                    ");
				for (var c: page.allCategories) {
					jteOutput.writeContent("\r\n                      <option");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(c)) {
						jteOutput.writeContent(" value=\"");
						jteOutput.setContext("option", "value");
						jteOutput.writeUserContent(c);
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(">");
					jteOutput.setContext("option", null);
					jteOutput.writeUserContent(c);
					jteOutput.writeContent("</option>\r\n                    ");
				}
				jteOutput.writeContent("\r\n                </select>\r\n                <div class=\"text-center\">\r\n                    <button type=\"submit\" class=\"btn btn-sm mt-3 btn-submit\">Submit</button>\r\n                </div>\r\n            </form>\r\n        </div>\r\n        <div class=\"col-sm-4\">\r\n        </div>\r\n    </div>\r\n    <div class=\"row\">\r\n\t   ");
				for (Article article : page.allTopHeadings) {
					jteOutput.writeContent("\r\n        <div class=\"col-sm-4 mt-3\">\r\n            <div class=\"card\">\r\n            \t");
					if (article.getUrlToImage() != null) {
						jteOutput.writeContent("\r\n                \t<img");
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
						jteOutput.writeContent(">\r\n                ");
					}
					jteOutput.writeContent("\r\n                <div class=\"card-body\">\r\n                    <h5 class=\"card-title\">");
					jteOutput.setContext("h5", null);
					jteOutput.writeUserContent(article.getTitle());
					jteOutput.writeContent("</h5>\r\n                    <p class=\"card-text\">");
					jteOutput.setContext("p", null);
					jteOutput.writeUserContent(article.getDescription());
					jteOutput.writeContent("</p>\r\n                    <a");
					if (gg.jte.runtime.TemplateUtils.isAttributeRendered(article.getUrl())) {
						jteOutput.writeContent(" href=\"");
						jteOutput.setContext("a", "href");
						jteOutput.writeUserContent(article.getUrl());
						jteOutput.writeContent("\"");
					}
					jteOutput.writeContent(" class=\"btn btn-primary\">See more...</a>\r\n                </div>\r\n                ");
					if (article.getPublishedAt() != null) {
						jteOutput.writeContent("\r\n                <div class=\"card-footer text-muted col\">\r\n                  Date: ");
						jteOutput.setContext("div", null);
						jteOutput.writeUserContent(article.getPublishedAt().toString().substring(0,10));
						jteOutput.writeContent(" Time: ");
						jteOutput.setContext("div", null);
						jteOutput.writeUserContent(article.getPublishedAt().toString().substring(11,16));
						jteOutput.writeContent("\r\n                </div>\r\n                ");
					}
					jteOutput.writeContent("\r\n            </div>\r\n        </div>\r\n        ");
				}
				jteOutput.writeContent("\r\n    </div>\r\n</div>\r\n");
			}
		});
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		IndexPage page = (IndexPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
