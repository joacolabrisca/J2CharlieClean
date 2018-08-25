<h1> Uso </h1>

<h2> Obtener una instancia de la librería </h2>
<p> 
	<i> WikipediaServiceModule.getInstance().getWikipediaService() </i> <br>
	Con esta operación obtenemos una instancia de la librería.
</p>

<h2> Obtener una definición a partir de un término </h2>
<p> 
	<i> instanciaAPI.getMeaning(term) </i> <br> 
	Con esta operación se obtendrá un String con el resultado de buscar term en la Wikipedia. Tener en cuenta que instanciaAPI es la instancia conseguida en la operación anterior.<br> <br>
	Observaciones: <br>
	--> La operación podría lanzar la excepción IOException en caso de que ocurra un error. <br>
	--> La operación puede llegar a retornar el String vacío o nulo.
</p>

