package web.app.util;
import java.nio.file.Path;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;

public class TemplateEngineCreator {
	public static TemplateEngine create(boolean isDevEnv) {
		if(isDevEnv) {
			DirectoryCodeResolver codeResolver = new DirectoryCodeResolver(Path.of("src", "main", "resources","jte"));
			return TemplateEngine.create(codeResolver,ContentType.Html);
		}else {
			 return TemplateEngine.createPrecompiled(Path.of("jte-classes"), ContentType.Html);
		}
	}
}
