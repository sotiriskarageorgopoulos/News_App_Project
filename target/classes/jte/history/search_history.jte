@import web.app.controllers.history.SearchHistoryPage

@param SearchHistoryPage page

@layout.base(content = @`
<div class="container-fluid mt-5">
    <div class="row">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
        	@if(page.articles == null)
            	<h2 class="search-title-history">Search History</h2>
            @else
            	<h2 class="search-title-history">Results</h2>
            @endif
            @if(page.history != null)
            <ul class="list-group list-group-flush">
            	@for(var h: page.history)
	                <li class="list-group-item">
	                    <form method="POST" action="/fetch_from_history" class="form">
	                        <p>${h.getDesc()}</p>
	                        <p><i class="bi bi-calendar"></i> ${h.getDateTime().toString().substring(0,10)}</p>
	                        <p><i class="bi bi-clock"></i> ${h.getDateTime().toString().substring(11,16)}</p>
	                        <input type="hidden" name="id" value="${h.getId()}" />
	                        <div class="text-center">
	                            <button type="submit" class="btn btn-sm btn-submit">Search</button>
	                        </div>
	                    </form>
	                </li>
                @endfor
            </ul>
            @endif
        </div>
        <div class="col-sm-4"></div>
    </div>
    @if(page.articles != null) 
       <div class="container-fluid">
           <div class="row">
            @for(var article : page.articles)
		        <div class="col-sm-4 mt-3">
		            <div class="card">
		            	@if(article.getUrlToImage() != null)
		                	<img src="${article.getUrlToImage()}" class="card-img-top" alt="${article.getTitle()}">
		                @endif
		                <div class="card-body">
		                    <h5 class="card-title">${article.getTitle()}</h5>
		                    <p class="card-text">${article.getDescription()}</p>
		                    <a href="${article.getUrl()}" class="btn btn-primary">See more...</a>
		                </div>
		                @if(article.getPublishedAt() != null)
			                <div class="card-footer text-muted">
			                  ${article.getPublishedAt().toString()}
			                </div>
			            @endif
		            </div>
		        </div>
		    @endfor
		  </div>
		</div>
     @endif
</div>
`)