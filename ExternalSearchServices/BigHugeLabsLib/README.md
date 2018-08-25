# BigHugeLabsLib

Importar el submodulo del siguiente repositorio: https://github.com/joacolabrisca/bigHugeLabsLib.
Agregar la siguiente linea dentro de los includes del proyecto: include 'bigHugeLabsLib'  
Para obtener una instancia de searchService realizar la siguiente invocacion: SearchServiceModule.getInstance().getSearchService().
Para buscar un termino se debe invocar al metodo searchTerm(String term) donde term es el termino que se quiere buscar. Tener en cuenta que el metodo arroja la excepcion ServiceNotReachableException cuando el servicio no puede ser encontrado.
