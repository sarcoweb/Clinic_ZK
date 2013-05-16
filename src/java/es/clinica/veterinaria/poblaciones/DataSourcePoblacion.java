package es.clinica.veterinaria.poblaciones;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import org.hsqldb.jdbcDriver;

public enum DataSourcePoblacion {
	
    INSTANCE;

    private static final String url = "jdbc:mysql://localhost:3306/clinica";
    private static final String user = "root";
    private static final String pwd = "admin";

    private Connection conn = null;

    static {
            try {
                    //new jdbcDriver();
                    Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                    e.printStackTrace();
            }
    }

    private DataSourcePoblacion() {
            // drop the table if it exists
            try {
                    Statement stmt = this.getStatement();
                    //stmt.executeUpdate("drop table zk_poblacion if exists");
                    //stmt.executeUpdate("create table event (evtid VARCHAR(37) NOT NULL PRIMARY KEY, name VARCHAR(100), priority INTEGER, evtdate TIMESTAMP)");
                    stmt.executeUpdate("CREATE TABLE IF NOT EXISTS `zk_poblacion` ( " +
                                       " `id` int(11) NOT NULL AUTO_INCREMENT, " +
                                       " `provincia` int(11) NOT NULL, " +
                                       " `poblacion` varchar(200) NOT NULL, " +
                                       " PRIMARY KEY (`id`), " +
                                       " UNIQUE KEY `codigopostal` (`poblacion`) " +
                                       ") ENGINE=InnoDB  DEFAULT CHARSET=utf8;");
                    /*
                    stmt.executeUpdate("INSERT INTO `zk_poblacion` (`provincia`, `poblacion`) VALUES " +
                    " ( 1, 'Asparrena'), " +
                    " ( 1, 'Artziniega'), " +
                    " ( 1, 'Arrazua-Ubarrundia'), " +
                    " ( 1, 'Arraia-Maeztu'), " +
                    " ( 1, 'Armiñón'), " +
                    " ( 1, 'Aramaio'), " +
                    " ( 1, 'Añana'), " +
                    " ( 1, 'Amurrio'), " +
                    " ( 1, 'Alegría-Dulantzi'), " +
                    " ( 1, 'Ayala/Aiara'), " +
                    " ( 1, 'Baños de Ebro/Mañueta'), " +
                    " ( 1, 'Barrundia'), " +
                    " ( 1, 'Berantevilla'), " +
                    " ( 1, 'Bernedo'), " +
                    " ( 1, 'Campezo/Kanpezu'), " +
                    " ( 1, 'Elburgo/Burgelu'), " +
                    " ( 1, 'Elciego'), " +
                    " ( 1, 'Elvillar/Bilar'), " +
                    " ( 1, 'Harana/Valle de Arana'), " +
                    " ( 1, 'Iruña Oka/Iruña de Oca'), " +
                    " ( 1, 'Iruraiz-Gauna'), " +
                    " ( 1, 'Kripan'), " +
                    " ( 1, 'Kuartango'), " +
                    " ( 1, 'Labastida/Bastida'), " +
                    " ( 1, 'Lagrán'), " +
                    " ( 1, 'Laguardia'), " +
                    " ( 1, 'Lanciego/Lantziego'), " +
                    " ( 1, 'Lantarón'), " +
                    " ( 1, 'Lapuebla de Labarca'), " +
                    " ( 1, 'Laudio/Llodio'), " +
                    " ( 1, 'Legutiano'), " +
                    " ( 1, 'Leza'), " +
                    " ( 1, 'Moreda de Álava'), " +
                    " ( 1, 'Navaridas'), " +
                    " ( 1, 'Okondo'), " +
                    " ( 1, 'Oyón-Oion'), " +
                    " ( 1, 'Peñacerrada-Urizaharra'), " +
                    " ( 1, 'Ribera Alta'), " +
                    " ( 1, 'Ribera Baja/Erribera Beitia'), " +
                    " ( 1, 'Salvatierra/Agurain'), " +
                    " ( 1, 'Samaniego'), " +
                    " ( 1, 'San Millán/Donemiliaga'), " +
                    " ( 1, 'Urkabustaiz'), " +
                    " ( 1, 'Valdegovía/Gaubea'), " +
                    " ( 1, 'Villabuena de Álava/Eskuernaga'), " +
                    " ( 1, 'Vitoria-Gasteiz'), " +
                    " ( 1, 'Yécora/Iekora'), " +
                    " ( 1, 'Zalduondo'), " +
                    " ( 1, 'Zambrana'), " +
                    " ( 1, 'Zigoitia'), " +
                    " ( 1, 'Zuia'), " +
                    " ( 2, 'Abengibre'), " +
                    " ( 2, 'Alatoz'), " +
                    " ( 2, 'Albacete'), " +
                    " ( 2, 'Albatana'), " +
                    " ( 2, 'Alborea'), " +
                    " ( 2, 'Alcadozo'), " +
                    " ( 2, 'Alcalá del Júcar'), " +
                    " ( 2, 'Alcaraz'), " +
                    " ( 2, 'Almansa'), " +
                    " ( 2, 'Alpera'), " +
                    " ( 2, 'Ayna'), " +
                    " ( 2, 'Balazote'), " +
                    " ( 2, 'Ballestero (El)'), " +
                    " ( 2, 'Balsa de Ves'), " +
                    " ( 2, 'Barrax'), " +
                    " ( 2, 'Bienservida'), " +
                    " ( 2, 'Bogarra'), " +
                    " ( 2, 'Bonete'), " +
                    " ( 2, 'Bonillo (El)'), " +
                    " ( 2, 'Carcelén'), " +
                    " ( 2, 'Casas de Juan Núñez'), " +
                    " ( 2, 'Casas de Lázaro'), " +
                    " ( 2, 'Casas de Ves'), " +
                    " ( 2, 'Casas-Ibáñez'), " +
                    " ( 2, 'Caudete'), " +
                    " ( 2, 'Cenizate'), " +
                    " ( 2, 'Chinchilla de Monte-Aragón'), " +
                    " ( 2, 'Corral-Rubio'), " +
                    " ( 2, 'Cotillas'), " +
                    " ( 2, 'Elche de la Sierra'), " +
                    " ( 2, 'Férez'), " +
                    " ( 2, 'Fuensanta'), " +
                    " ( 2, 'Fuente-Álamo'), " +
                    " ( 2, 'Fuentealbilla'), " +
                    " ( 2, 'Gineta (La)'), " +
                    " ( 2, 'Golosalvo'), " +
                    " ( 2, 'Hellín'), " +
                    " ( 2, 'Herrera (La)'), " +
                    " ( 2, 'Higueruela'), " +
                    " ( 2, 'Hoya-Gonzalo'), " +
                    " ( 2, 'Jorquera'), " +
                    " ( 2, 'Letur'), " +
                    " ( 2, 'Lezuza'), " +
                    " ( 2, 'Liétor'), " +
                    " ( 2, 'Madrigueras'), " +
                    " ( 2, 'Mahora'), " +
                    " ( 2, 'Masegoso'), " +
                    " ( 2, 'Minaya'), " +
                    " ( 2, 'Molinicos'), " +
                    " ( 2, 'Montalvos'), " +
                    " ( 2, 'Montealegre del Castillo'), " +
                    " ( 2, 'Motilleja'), " +
                    " ( 2, 'Munera'), " +
                    " ( 2, 'Navas de Jorquera'), " +
                    " ( 2, 'Nerpio'), " +
                    " ( 2, 'Ontur'), " +
                    " ( 2, 'Ossa de Montiel'), " +
                    " ( 2, 'Paterna del Madera'), " +
                    " ( 2, 'Peñas de San Pedro'), " +
                    " ( 2, 'Peñascosa'), " +
                    " ( 2, 'Pétrola'), " +
                    " ( 2, 'Povedilla'), " +
                    " ( 2, 'Pozo Cañada'), " +
                    " ( 2, 'Pozohondo'), " +
                    " ( 2, 'Pozo-Lorente'), " +
                    " ( 2, 'Pozuelo'), " +
                    " ( 2, 'Recueja (La)'), " +
                    " ( 2, 'Riópar'), " +
                    " ( 2, 'Robledo'), " +
                    " ( 2, 'Roda (La)'), " +
                    " ( 2, 'Salobre'), " +
                    " ( 2, 'San Pedro'), " +
                    " ( 2, 'Socovos'), " +
                    " ( 2, 'Tarazona de la Mancha'), " +
                    " ( 2, 'Tobarra'), " +
                    " ( 2, 'Valdeganga'), " +
                    " ( 2, 'Vianos'), " +
                    " ( 2, 'Villa de Ves'), " +
                    " ( 2, 'Villalgordo del Júcar'), " +
                    " ( 2, 'Villamalea'), " +
                    " ( 2, 'Villapalacios'), " +
                    " ( 2, 'Villarrobledo'), " +
                    " ( 2, 'Villatoya'), " +
                    " ( 2, 'Villavaliente'), " +
                    " ( 2, 'Villaverde de Guadalimar'), " +
                    " ( 2, 'Viveros'), " +
                    " ( 2, 'Yeste'), " +
                    " ( 3, 'Adsubia'), " +
                    " ( 3, 'Agost'), " +
                    " ( 3, 'Agres'), " +
                    " ( 3, 'Aigües'), " +
                    " ( 3, 'Albatera'), " +
                    " ( 3, 'Alcalalí'), " +
                    " ( 3, 'Alcocer de Planes'), " +
                    " ( 3, 'Alcoleja'), " +
                    " ( 3, 'Alcoy/Alcoi'), " +
                    " ( 3, 'Alfafara'), " +
                    " ( 3, 'Alfàs del Pi (l'')'), " +
                    " ( 3, 'Algorfa'), " +
                    " ( 3, 'Algueña'), " +
                    " ( 3, 'Alicante/Alacant'), " +
                    " ( 3, 'Almoradí'), " +
                    " ( 3, 'Almudaina'), " +
                    " ( 3, 'Alqueria d''Asnar (l'')'), " +
                    " ( 3, 'Altea'), " +
                    " ( 3, 'Aspe'), " +
                    " ( 3, 'Balones'), " +
                    " ( 3, 'Banyeres de Mariola'), " +
                    " ( 3, 'Benasau'), " +
                    " ( 3, 'Beneixama'), " +
                    " ( 3, 'Benejúzar'), " +
                    " ( 3, 'Benferri'), " +
                    " ( 3, 'Beniarbeig'), " +
                    " ( 3, 'Beniardá'), " +
                    " ( 3, 'Beniarrés'), " +
                    " ( 3, 'Benidoleig'), " +
                    " ( 3, 'Benidorm'), " +
                    " ( 3, 'Benifallim'), " +
                    " ( 3, 'Benifato'), " +
                    " ( 3, 'Benigembla'), " +
                    " ( 3, 'Benijófar'), " +
                    " ( 3, 'Benilloba'), " +
                    " ( 3, 'Benillup'), " +
                    " ( 3, 'Benimantell'), " +
                    " ( 3, 'Benimarfull'), " +
                    " ( 3, 'Benimassot'), " +
                    " ( 3, 'Benimeli'), " +
                    " ( 3, 'Benissa'), " +
                    " ( 3, 'Benitachell/Poble Nou de Benitatxell (el)'), " +
                    " ( 3, 'Biar'), " +
                    " ( 3, 'Bigastro'), " +
                    " ( 3, 'Bolulla'), " +
                    " ( 3, 'Busot'), " +
                    " ( 3, 'Callosa de Segura'), " +
                    " ( 3, 'Callosa d''En Sarrià'), " +
                    " ( 3, 'Calpe/Calp'), " +
                    " ( 3, 'Campello (el)'), " +
                    " ( 3, 'Campo de Mirra/Camp de Mirra (el)'), " +
                    " ( 3, 'Cañada'), " +
                    " ( 3, 'Castalla'), " +
                    " ( 3, 'Castell de Castells'), " +
                    " ( 3, 'Castell de Guadalest (el)'), " +
                    " ( 3, 'Catral'), " +
                    " ( 3, 'Cocentaina'), " +
                    " ( 3, 'Confrides'), " +
                    " ( 3, 'Cox'), " +
                    " ( 3, 'Crevillent'), " +
                    " ( 3, 'Daya Nueva'), " +
                    " ( 3, 'Daya Vieja'), " +
                    " ( 3, 'Dénia'), " +
                    " ( 3, 'Dolores'), " +
                    " ( 3, 'Elche/Elx'), " +
                    " ( 3, 'Elda'), " +
                    " ( 3, 'Facheca'), " +
                    " ( 3, 'Famorca'), " +
                    " ( 3, 'Finestrat'), " +
                    " ( 3, 'Fondó de les Neus (el)'), " +
                    " ( 3, 'Formentera del Segura'), " +
                    " ( 3, 'Gaianes'), " +
                    " ( 3, 'Gata de Gorgos'), " +
                    " ( 3, 'Gorga'), " +
                    " ( 3, 'Granja de Rocamora'), " +
                    " ( 3, 'Guardamar del Segura'), " +
                    " ( 3, 'Hondón de los Frailes'), " +
                    " ( 3, 'Ibi'), " +
                    " ( 3, 'Jacarilla'), " +
                    " ( 3, 'Jalón/Xaló'), " +
                    " ( 3, 'Jávea/Xàbia'), " +
                    " ( 3, 'Jijona/Xixona'), " +
                    " ( 3, 'Llíber'), " +
                    " ( 3, 'Lorcha/Orxa (l'')'), " +
                    " ( 3, 'Millena'), " +
                    " ( 3, 'Monforte del Cid'), " +
                    " ( 3, 'Monóvar/Monòver'), " +
                    " ( 3, 'Montesinos (Los)'), " +
                    " ( 3, 'Murla'), " +
                    " ( 3, 'Muro de Alcoy'), " +
                    " ( 3, 'Mutxamel'), " +
                    " ( 3, 'Novelda'), " +
                    " ( 3, 'Nucia (la)'), " +
                    " ( 3, 'Ondara'), " +
                    " ( 3, 'Onil'), " +
                    " ( 3, 'Orba'), " +
                    " ( 3, 'Orihuela'), " +
                    " ( 3, 'Orxeta'), " +
                    " ( 3, 'Parcent'), " +
                    " ( 3, 'Pedreguer'), " +
                    " ( 3, 'Pego'), " +
                    " ( 3, 'Penàguila'), " +
                    " ( 3, 'Petrer'), " +
                    " ( 3, 'Pilar de la Horadada'), " +
                    " ( 3, 'Pinós (el)/Pinoso'), " +
                    " ( 3, 'Planes'), " +
                    " ( 3, 'Poblets (els)'), " +
                    " ( 3, 'Polop'), " +
                    " ( 3, 'Quatretondeta'), " +
                    " ( 3, 'Rafal'), " +
                    " ( 3, 'Ràfol d''Almúnia (El)'), " +
                    " ( 3, 'Redován'), " +
                    " ( 3, 'Relleu'), " +
                    " ( 3, 'Rojales'), " +
                    " ( 3, 'Romana (la)'), " +
                    " ( 3, 'Sagra'), " +
                    " ( 3, 'Salinas'), " +
                    " ( 3, 'San Fulgencio'), " +
                    " ( 3, 'San Isidro'), " +
                    " ( 3, 'San Miguel de Salinas'), " +
                    " ( 3, 'San Vicente del Raspeig/Sant Vicent del Raspeig'), " +
                    " ( 3, 'Sanet y Negrals'), " +
                    " ( 3, 'Sant Joan d''Alacant'), " +
                    " ( 3, 'Santa Pola'), " +
                    " ( 3, 'Sax'), " +
                    " ( 3, 'Sella'), " +
                    " ( 3, 'Senija'), " +
                    " ( 3, 'Tàrbena'), " +
                    " ( 3, 'Teulada'), " +
                    " ( 3, 'Tibi'), " +
                    " ( 3, 'Tollos'), " +
                    " ( 3, 'Tormos'), " +
                    " ( 3, 'Torremanzanas/Torre de les Maçanes (la)'), " +
                    " ( 3, 'Torrevieja'), " +
                    " ( 3, 'Vall d''Alcalà (la)'), " +
                    " ( 3, 'Vall de Ebo'), " +
                    " ( 3, 'Vall de Gallinera'), " +
                    " ( 3, 'Vall de Laguar (la)'), " +
                    " ( 3, 'Verger (el)'), " +
                    " ( 3, 'Villajoyosa/Vila Joiosa (la)'), " +
                    " ( 3, 'Villena'), " +
                    " ( 4, 'Abla'), " +
                    " ( 4, 'Abrucena'), " +
                    " ( 4, 'Adra'), " +
                    " ( 4, 'Albánchez'), " +
                    " ( 4, 'Alboloduy'), " +
                    " ( 4, 'Albox'), " +
                    " ( 4, 'Alcolea'), " +
                    " ( 4, 'Alcóntar'), " +
                    " ( 4, 'Alcudia de Monteagud'), " +
                    " ( 4, 'Alhabia'), " +
                    " ( 4, 'Alhama de Almería'), " +
                    " ( 4, 'Alicún'), " +
                    " ( 4, 'Almería'), " +
                    " ( 4, 'Almócita'), " +
                    " ( 4, 'Alsodux'), " +
                    " ( 4, 'Antas'), " +
                    " ( 4, 'Arboleas'), " +
                    " ( 4, 'Armuña de Almanzora'), " +
                    " ( 4, 'Bacares'), " +
                    " ( 4, 'Bayárcal'), " +
                    " ( 4, 'Bayarque'), " +
                    " ( 4, 'Bédar'), " +
                    " ( 4, 'Beires'), " +
                    " ( 4, 'Benahadux'), " +
                    " ( 4, 'Benitagla'), " +
                    " ( 4, 'Benizalón'), " +
                    " ( 4, 'Bentarique'), " +
                    " ( 4, 'Berja'), " +
                    " ( 4, 'Canjáyar'), " +
                    " ( 4, 'Cantoria'), " +
                    " ( 4, 'Carboneras'), " +
                    " ( 4, 'Castro de Filabres'), " +
                    " ( 4, 'Chercos'), " +
                    " ( 4, 'Chirivel'), " +
                    " ( 4, 'Cóbdar'), " +
                    " ( 4, 'Cuevas del Almanzora'), " +
                    " ( 4, 'Dalías'), " +
                    " ( 4, 'Ejido (El)'), " +
                    " ( 4, 'Enix'), " +
                    " ( 4, 'Felix'), " +
                    " ( 4, 'Fines'), " +
                    " ( 4, 'Fiñana'), " +
                    " ( 4, 'Fondón'), " +
                    " ( 4, 'Gádor'), " +
                    " ( 4, 'Gallardos (Los)'), " +
                    " ( 4, 'Garrucha'), " +
                    " ( 4, 'Gérgal'), " +
                    " ( 4, 'Huécija'), " +
                    " ( 4, 'Huércal de Almería'), " +
                    " ( 4, 'Huércal-Overa'), " +
                    " ( 4, 'Illar'), " +
                    " ( 4, 'Instinción'), " +
                    " ( 4, 'Laroya'), " +
                    " ( 4, 'Láujar de Andarax'), " +
                    " ( 4, 'Líjar'), " +
                    " ( 4, 'Lubrín'), " +
                    " ( 4, 'Lucainena de las Torres'), " +
                    " ( 4, 'Lúcar'), " +
                    " ( 4, 'Macael'), " +
                    " ( 4, 'María'), " +
                    " ( 4, 'Mojácar'), " +
                    " ( 4, 'Mojonera (La)'), " +
                    " ( 4, 'Nacimiento'), " +
                    " ( 4, 'Níjar'), " +
                    " ( 4, 'Ohanes'), " +
                    " ( 4, 'Olula de Castro'), " +
                    " ( 4, 'Olula del Río'), " +
                    " ( 4, 'Oria'), " +
                    " ( 4, 'Padules'), " +
                    " ( 4, 'Partaloa'), " +
                    " ( 4, 'Paterna del Río'), " +
                    " ( 4, 'Pechina'), " +
                    " ( 4, 'Pulpí'), " +
                    " ( 4, 'Purchena'), " +
                    " ( 4, 'Rágol'), " +
                    " ( 4, 'Rioja'), " +
                    " ( 4, 'Roquetas de Mar'), " +
                    " ( 4, 'Santa Cruz de Marchena'), " +
                    " ( 4, 'Santa Fe de Mondújar'), " +
                    " ( 4, 'Senés'), " +
                    " ( 4, 'Serón'), " +
                    " ( 4, 'Sierro'), " +
                    " ( 4, 'Somontín'), " +
                    " ( 4, 'Sorbas'), " +
                    " ( 4, 'Suflí'), " +
                    " ( 4, 'Tabernas'), " +
                    " ( 4, 'Taberno'), " +
                    " ( 4, 'Tahal'), " +
                    " ( 4, 'Terque'), " +
                    " ( 4, 'Tíjola'), " +
                    " ( 4, 'Tres Villas (Las)'), " +
                    " ( 4, 'Turre'), " +
                    " ( 4, 'Turrillas'), " +
                    " ( 4, 'Uleila del Campo'), " +
                    " ( 4, 'Urrácal'), " +
                    " ( 4, 'Velefique'), " +
                    " ( 4, 'Vélez-Blanco'), " +
                    " ( 4, 'Vélez-Rubio'), " +
                    " ( 4, 'Vera'), " +
                    " ( 4, 'Viator'), " +
                    " ( 4, 'Vícar'), " +
                    " ( 4, 'Zurgena'), " +
                    " ( 5, 'Adanero'), " +
                    " ( 5, 'Adrada (La)'), " +
                    " ( 5, 'Albornos'), " +
                    " ( 5, 'Aldeanueva de Santa Cruz'), " +
                    " ( 5, 'Aldeaseca'), " +
                    " ( 5, 'Aldehuela (La)'), " +
                    " ( 5, 'Amavida'), " +
                    " ( 5, 'Arenal (El)'), " +
                    " ( 5, 'Arenas de San Pedro'), " +
                    " ( 5, 'Arevalillo'), " +
                    " ( 5, 'Arévalo'), " +
                    " ( 5, 'Aveinte'), " +
                    " ( 5, 'Avellaneda'), " +
                    " ( 5, 'Ávila'), " +
                    " ( 5, 'Barco de Ávila (El)'), " +
                    " ( 5, 'Barraco (El)'), " +
                    " ( 5, 'Barromán'), " +
                    " ( 5, 'Becedas'), " +
                    " ( 5, 'Becedillas'), " +
                    " ( 5, 'Bercial de Zapardiel'), " +
                    " ( 5, 'Berlanas (Las)'), " +
                    " ( 5, 'Bernuy-Zapardiel'), " +
                    " ( 5, 'Berrocalejo de Aragona'), " +
                    " ( 5, 'Blascomillán'), " +
                    " ( 5, 'Blasconuño de Matacabras'), " +
                    " ( 5, 'Blascosancho'), " +
                    " ( 5, 'Bohodón (El)'), " +
                    " ( 5, 'Bohoyo'), " +
                    " ( 5, 'Bonilla de la Sierra'), " +
                    " ( 5, 'Brabos'), " +
                    " ( 5, 'Bularros'), " +
                    " ( 5, 'Burgohondo'), " +
                    " ( 5, 'Cabezas de Alambre'), " +
                    " ( 5, 'Cabezas del Pozo'), " +
                    " ( 5, 'Cabezas del Villar'), " +
                    " ( 5, 'Cabizuela'), " +
                    " ( 5, 'Canales'), " +
                    " ( 5, 'Candeleda'), " +
                    " ( 5, 'Cantiveros'), " +
                    " ( 5, 'Cardeñosa'), " +
                    " ( 5, 'Carrera (La)'), " +
                    " ( 5, 'Casas del Puerto'), " +
                    " ( 5, 'Casasola'), " +
                    " ( 5, 'Casavieja'), " +
                    " ( 5, 'Casillas'), " +
                    " ( 5, 'Castellanos de Zapardiel'), " +
                    " ( 5, 'Cebreros'), " +
                    " ( 5, 'Cepeda la Mora'), " +
                    " ( 5, 'Chamartín'), " +
                    " ( 5, 'Cillán'), " +
                    " ( 5, 'Cisla'), " +
                    " ( 5, 'Colilla (La)'), " +
                    " ( 5, 'Collado de Contreras'), " +
                    " ( 5, 'Collado del Mirón'), " +
                    " ( 5, 'Constanzana'), " +
                    " ( 5, 'Crespos'), " +
                    " ( 5, 'Cuevas del Valle'), " +
                    " ( 5, 'Diego del Carpio'), " +
                    " ( 5, 'Donjimeno'), " +
                    " ( 5, 'Donvidas'), " +
                    " ( 5, 'Espinosa de los Caballeros'), " +
                    " ( 5, 'Flores de Ávila'), " +
                    " ( 5, 'Fontiveros'), " +
                    " ( 5, 'Fresnedilla'), " +
                    " ( 5, 'Fresno (El)'), " +
                    " ( 5, 'Fuente el Saúz'), " +
                    " ( 5, 'Fuentes de Año'), " +
                    " ( 5, 'Gallegos de Altamiros'), " +
                    " ( 5, 'Gallegos de Sobrinos'), " +
                    " ( 5, 'Garganta del Villar'), " +
                    " ( 5, 'Gavilanes'), " +
                    " ( 5, 'Gemuño'), " +
                    " ( 5, 'Gil García'), " +
                    " ( 5, 'Gilbuena'), " +
                    " ( 5, 'Gimialcón'), " +
                    " ( 5, 'Gotarrendura'), " +
                    " ( 5, 'Grandes y San Martín'), " +
                    " ( 5, 'Guisando'), " +
                    " ( 5, 'Gutierre-Muñoz'), " +
                    " ( 5, 'Hernansancho'), " +
                    " ( 5, 'Herradón de Pinares'), " +
                    " ( 5, 'Herreros de Suso'), " +
                    " ( 5, 'Higuera de las Dueñas'), " +
                    " ( 5, 'Hija de Dios (La)'), " +
                    " ( 5, 'Horcajada (La)'), " +
                    " ( 5, 'Horcajo de las Torres'), " +
                    " ( 5, 'Hornillo (El)'), " +
                    " ( 5, 'Hoyo de Pinares (El)'), " +
                    " ( 5, 'Hoyocasero'), " +
                    " ( 5, 'Hoyorredondo'), " +
                    " ( 5, 'Hoyos de Miguel Muñoz'), " +
                    " ( 5, 'Hoyos del Collado'), " +
                    " ( 5, 'Hoyos del Espino'), " +
                    " ( 5, 'Hurtumpascual'), " +
                    " ( 5, 'Junciana'), " +
                    " ( 5, 'Langa'), " +
                    " ( 5, 'Lanzahíta'), " +
                    " ( 5, 'Llanos de Tormes (Los)'), " +
                    " ( 5, 'Losar del Barco (El)'), " +
                    " ( 5, 'Madrigal de las Altas Torres'), " +
                    " ( 5, 'Maello'), " +
                    " ( 5, 'Malpartida de Corneja'), " +
                    " ( 5, 'Mamblas'), " +
                    " ( 5, 'Mancera de Arriba'), " +
                    " ( 5, 'Manjabálago'), " +
                    " ( 5, 'Marlín'), " +
                    " ( 5, 'Martiherrero'), " +
                    " ( 5, 'Martínez'), " +
                    " ( 5, 'Mediana de Voltoya'), " +
                    " ( 5, 'Medinilla'), " +
                    " ( 5, 'Mengamuñoz'), " +
                    " ( 5, 'Mesegar de Corneja'), " +
                    " ( 5, 'Mijares'), " +
                    " ( 5, 'Mingorría'), " +
                    " ( 5, 'Mirón (El)'), " +
                    " ( 5, 'Mironcillo'), " +
                    " ( 5, 'Mirueña de los Infanzones'), " +
                    " ( 5, 'Mombeltrán'), " +
                    " ( 5, 'Monsalupe'), " +
                    " ( 5, 'Moraleja de Matacabras'), " +
                    " ( 5, 'Muñana'), " +
                    " ( 5, 'Muñico'), " +
                    " ( 5, 'Muñogalindo'), " +
                    " ( 5, 'Muñogrande'), " +
                    " ( 5, 'Muñomer del Peco'), " +
                    " ( 5, 'Muñopepe'), " +
                    " ( 5, 'Muñosancho'), " +
                    " ( 5, 'Muñotello'), " +
                    " ( 5, 'Narrillos del Álamo'), " +
                    " ( 5, 'Narrillos del Rebollar'), " +
                    " ( 5, 'Narros de Saldueña'), " +
                    " ( 5, 'Narros del Castillo'), " +
                    " ( 5, 'Narros del Puerto'), " +
                    " ( 5, 'Nava de Arévalo'), " +
                    " ( 5, 'Nava del Barco'), " +
                    " ( 5, 'Navacepedilla de Corneja'), " +
                    " ( 5, 'Navadijos'), " +
                    " ( 5, 'Navaescurial'), " +
                    " ( 5, 'Navahondilla'), " +
                    " ( 5, 'Navalacruz'), " +
                    " ( 5, 'Navalmoral'), " +
                    " ( 5, 'Navalonguilla'), " +
                    " ( 5, 'Navalosa'), " +
                    " ( 5, 'Navalperal de Pinares'), " +
                    " ( 5, 'Navalperal de Tormes'), " +
                    " ( 5, 'Navaluenga'), " +
                    " ( 5, 'Navaquesera'), " +
                    " ( 5, 'Navarredonda de Gredos'), " +
                    " ( 5, 'Navarredondilla'), " +
                    " ( 5, 'Navarrevisca'), " +
                    " ( 5, 'Navas del Marqués (Las)'), " +
                    " ( 5, 'Navatalgordo'), " +
                    " ( 5, 'Navatejares'), " +
                    " ( 5, 'Neila de San Miguel'), " +
                    " ( 5, 'Niharra'), " +
                    " ( 5, 'Ojos-Albos'), " +
                    " ( 5, 'Orbita'), " +
                    " ( 5, 'Oso (El)'), " +
                    " ( 5, 'Padiernos'), " +
                    " ( 5, 'Pajares de Adaja'), " +
                    " ( 5, 'Palacios de Goda'), " +
                    " ( 5, 'Papatrigo'), " +
                    " ( 5, 'Parral (El)'), " +
                    " ( 5, 'Pascualcobo'), " +
                    " ( 5, 'Pedro Bernardo'), " +
                    " ( 5, 'Pedro-Rodríguez'), " +
                    " ( 5, 'Peguerinos'), " +
                    " ( 5, 'Peñalba de Ávila'), " +
                    " ( 5, 'Piedrahíta'), " +
                    " ( 5, 'Piedralaves'), " +
                    " ( 5, 'Poveda'), " +
                    " ( 5, 'Poyales del Hoyo'), " +
                    " ( 5, 'Pozanco'), " +
                    " ( 5, 'Pradosegar'), " +
                    " ( 5, 'Puerto Castilla'), " +
                    " ( 5, 'Rasueros'), " +
                    " ( 5, 'Riocabado'), " +
                    " ( 5, 'Riofrío'), " +
                    " ( 5, 'Rivilla de Barajas'), " +
                    " ( 5, 'Salobral'), " +
                    " ( 5, 'Salvadiós'), " +
                    " ( 5, 'San Bartolomé de Béjar'), " +
                    " ( 5, 'San Bartolomé de Corneja'), " +
                    " ( 5, 'San Bartolomé de Pinares'), " +
                    " ( 5, 'San Esteban de los Patos'), " +
                    " ( 5, 'San Esteban de Zapardiel'), " +
                    " ( 5, 'San Esteban del Valle'), " +
                    " ( 5, 'San García de Ingelmos'), " +
                    " ( 5, 'San Juan de Gredos'), " +
                    " ( 5, 'San Juan de la Encinilla'), " +
                    " ( 5, 'San Juan de la Nava'), " +
                    " ( 5, 'San Juan del Molinillo'), " +
                    " ( 5, 'San Juan del Olmo'), " +
                    " ( 5, 'San Lorenzo de Tormes'), " +
                    " ( 5, 'San Martín de la Vega del Alberche'), " +
                    " ( 5, 'San Martín del Pimpollar'), " +
                    " ( 5, 'San Miguel de Corneja'), " +
                    " ( 5, 'San Miguel de Serrezuela'), " +
                    " ( 5, 'San Pascual'), " +
                    " ( 5, 'San Pedro del Arroyo'), " +
                    " ( 5, 'San Vicente de Arévalo'), " +
                    " ( 5, 'Sanchidrián'), " +
                    " ( 5, 'Sanchorreja'), " +
                    " ( 5, 'Santa Cruz de Pinares'), " +
                    " ( 5, 'Santa Cruz del Valle'), " +
                    " ( 5, 'Santa María de los Caballeros'), " +
                    " ( 5, 'Santa María del Arroyo'), " +
                    " ( 5, 'Santa María del Berrocal'), " +
                    " ( 5, 'Santa María del Cubillo'), " +
                    " ( 5, 'Santa María del Tiétar'), " +
                    " ( 5, 'Santiago del Collado'), " +
                    " ( 5, 'Santiago del Tormes'), " +
                    " ( 5, 'Santo Domingo de las Posadas'), " +
                    " ( 5, 'Santo Tomé de Zabarcos'), " +
                    " ( 5, 'Serrada (La)'), " +
                    " ( 5, 'Serranillos'), " +
                    " ( 5, 'Sigeres'), " +
                    " ( 5, 'Sinlabajos'), " +
                    " ( 5, 'Solana de Ávila'), " +
                    " ( 5, 'Solana de Rioalmar'), " +
                    " ( 5, 'Solosancho'), " +
                    " ( 5, 'Sotalbo'), " +
                    " ( 5, 'Sotillo de la Adrada'), " +
                    " ( 5, 'Tiemblo (El)'), " +
                    " ( 5, 'Tiñosillos'), " +
                    " ( 5, 'Tolbaños'), " +
                    " ( 5, 'Tormellas'), " +
                    " ( 5, 'Tornadizos de Ávila'), " +
                    " ( 5, 'Torre (La)'), " +
                    " ( 5, 'Tórtoles'), " +
                    " ( 5, 'Umbrías'), " +
                    " ( 5, 'Vadillo de la Sierra'), " +
                    " ( 5, 'Valdecasa'), " +
                    " ( 5, 'Vega de Santa María'), " +
                    " ( 5, 'Velayos'), " +
                    " ( 5, 'Villaflor'), " +
                    " ( 5, 'Villafranca de la Sierra'), " +
                    " ( 5, 'Villanueva de Ávila'), " +
                    " ( 5, 'Villanueva de Gómez'), " +
                    " ( 5, 'Villanueva del Aceral'), " +
                    " ( 5, 'Villanueva del Campillo'), " +
                    " ( 5, 'Villar de Corneja'), " +
                    " ( 5, 'Villarejo del Valle'), " +
                    " ( 5, 'Villatoro'), " +
                    " ( 5, 'Viñegra de Moraña'), " +
                    " ( 5, 'Vita'), " +
                    " ( 5, 'Zapardiel de la Cañada'), " +
                    " ( 5, 'Zapardiel de la Ribera'), " +
                    " ( 6, 'Acedera'), " +
                    " ( 6, 'Aceuchal'), " +
                    " ( 6, 'Ahillones'), " +
                    " ( 6, 'Alange'), " +
                    " ( 6, 'Albuera (La)'), " +
                    " ( 6, 'Alburquerque'), " +
                    " ( 6, 'Alconchel'), " +
                    " ( 6, 'Alconera'), " +
                    " ( 6, 'Aljucén'), " +
                    " ( 6, 'Almendral'), " +
                    " ( 6, 'Almendralejo'), " +
                    " ( 6, 'Arroyo de San Serván'), " +
                    " ( 6, 'Atalaya'), " +
                    " ( 6, 'Azuaga'), " +
                    " ( 6, 'Badajoz'), " +
                    " ( 6, 'Barcarrota'), " +
                    " ( 6, 'Baterno'), " +
                    " ( 6, 'Benquerencia de la Serena'), " +
                    " ( 6, 'Berlanga'), " +
                    " ( 6, 'Bienvenida'), " +
                    " ( 6, 'Bodonal de la Sierra'), " +
                    " ( 6, 'Burguillos del Cerro'), " +
                    " ( 6, 'Cabeza del Buey'), " +
                    " ( 6, 'Cabeza la Vaca'), " +
                    " ( 6, 'Calamonte'), " +
                    " ( 6, 'Calera de León'), " +
                    " ( 6, 'Calzadilla de los Barros'), " +
                    " ( 6, 'Campanario'), " +
                    " ( 6, 'Campillo de Llerena'), " +
                    " ( 6, 'Capilla'), " +
                    " ( 6, 'Carmonita'), " +
                    " ( 6, 'Carrascalejo (El)'), " +
                    " ( 6, 'Casas de Don Pedro'), " +
                    " ( 6, 'Casas de Reina'), " +
                    " ( 6, 'Castilblanco'), " +
                    " ( 6, 'Castuera'), " +
                    " ( 6, 'Cheles'), " +
                    " ( 6, 'Codosera (La)'), " +
                    " ( 6, 'Cordobilla de Lácara'), " +
                    " ( 6, 'Coronada (La)'), " +
                    " ( 6, 'Corte de Peleas'), " +
                    " ( 6, 'Cristina'), " +
                    " ( 6, 'Don Álvaro'), " +
                    " ( 6, 'Don Benito'), " +
                    " ( 6, 'Entrín Bajo'), " +
                    " ( 6, 'Esparragalejo'), " +
                    " ( 6, 'Esparragosa de la Serena'), " +
                    " ( 6, 'Esparragosa de Lares'), " +
                    " ( 6, 'Feria'), " +
                    " ( 6, 'Fregenal de la Sierra'), " +
                    " ( 6, 'Fuenlabrada de los Montes'), " +
                    " ( 6, 'Fuente de Cantos'), " +
                    " ( 6, 'Fuente del Arco'), " +
                    " ( 6, 'Fuente del Maestre'), " +
                    " ( 6, 'Fuentes de León'), " +
                    " ( 6, 'Garbayuela'), " +
                    " ( 6, 'Garlitos'), " +
                    " ( 6, 'Garrovilla (La)'), " +
                    " ( 6, 'Granja de Torrehermosa'), " +
                    " ( 6, 'Guareña'), " +
                    " ( 6, 'Haba (La)'), " +
                    " ( 6, 'Helechosa de los Montes'), " +
                    " ( 6, 'Herrera del Duque'), " +
                    " ( 6, 'Higuera de la Serena'), " +
                    " ( 6, 'Higuera de Llerena'), " +
                    " ( 6, 'Higuera de Vargas'), " +
                    " ( 6, 'Higuera la Real'), " +
                    " ( 6, 'Hinojosa del Valle'), " +
                    " ( 6, 'Hornachos'), " +
                    " ( 6, 'Jerez de los Caballeros'), " +
                    " ( 6, 'Lapa (La)'), " +
                    " ( 6, 'Llera'), " +
                    " ( 6, 'Llerena'), " +
                    " ( 6, 'Lobón'), " +
                    " ( 6, 'Magacela'), " +
                    " ( 6, 'Maguilla'), " +
                    " ( 6, 'Malcocinado'), " +
                    " ( 6, 'Malpartida de la Serena'), " +
                    " ( 6, 'Manchita'), " +
                    " ( 6, 'Medellín'), " +
                    " ( 6, 'Medina de las Torres'), " +
                    " ( 6, 'Mengabril'), " +
                    " ( 6, 'Mérida'), " +
                    " ( 6, 'Mirandilla'), " +
                    " ( 6, 'Monesterio'), " +
                    " ( 6, 'Montemolín'), " +
                    " ( 6, 'Monterrubio de la Serena'), " +
                    " ( 6, 'Montijo'), " +
                    " ( 6, 'Morera (La)'), " +
                    " ( 6, 'Nava de Santiago (La)'), " +
                    " ( 6, 'Navalvillar de Pela'), " +
                    " ( 6, 'Nogales'), " +
                    " ( 6, 'Oliva de la Frontera'), " +
                    " ( 6, 'Oliva de Mérida'), " +
                    " ( 6, 'Olivenza'), " +
                    " ( 6, 'Orellana de la Sierra'), " +
                    " ( 6, 'Orellana la Vieja'), " +
                    " ( 6, 'Palomas'), " +
                    " ( 6, 'Parra (La)'), " +
                    " ( 6, 'Peñalsordo'), " +
                    " ( 6, 'Peraleda del Zaucejo'), " +
                    " ( 6, 'Puebla de Alcocer'), " +
                    " ( 6, 'Puebla de la Calzada'), " +
                    " ( 6, 'Puebla de la Reina'), " +
                    " ( 6, 'Puebla de Obando'), " +
                    " ( 6, 'Puebla de Sancho Pérez'), " +
                    " ( 6, 'Puebla del Maestre'), " +
                    " ( 6, 'Puebla del Prior'), " +
                    " ( 6, 'Pueblonuevo del Guadiana'), " +
                    " ( 6, 'Quintana de la Serena'), " +
                    " ( 6, 'Reina'), " +
                    " ( 6, 'Rena'), " +
                    " ( 6, 'Retamal de Llerena'), " +
                    " ( 6, 'Ribera del Fresno'), " +
                    " ( 6, 'Risco'), " +
                    " ( 6, 'Roca de la Sierra (La)'), " +
                    " ( 6, 'Salvaleón'), " +
                    " ( 6, 'Salvatierra de los Barros'), " +
                    " ( 6, 'San Pedro de Mérida'), " +
                    " ( 6, 'San Vicente de Alcántara'), " +
                    " ( 6, 'Sancti-Spíritus'), " +
                    " ( 6, 'Santa Amalia'), " +
                    " ( 6, 'Santa Marta'), " +
                    " ( 6, 'Santos de Maimona (Los)'), " +
                    " ( 6, 'Segura de León'), " +
                    " ( 6, 'Siruela'), " +
                    " ( 6, 'Solana de los Barros'), " +
                    " ( 6, 'Talarrubias'), " +
                    " ( 6, 'Talavera la Real'), " +
                    " ( 6, 'Táliga'), " +
                    " ( 6, 'Tamurejo'), " +
                    " ( 6, 'Torre de Miguel Sesmero'), " +
                    " ( 6, 'Torremayor'), " +
                    " ( 6, 'Torremejía'), " +
                    " ( 6, 'Trasierra'), " +
                    " ( 6, 'Trujillanos'), " +
                    " ( 6, 'Usagre'), " +
                    " ( 6, 'Valdecaballeros'), " +
                    " ( 6, 'Valdelacalzada'), " +
                    " ( 6, 'Valdetorres'), " +
                    " ( 6, 'Valencia de las Torres'), " +
                    " ( 6, 'Valencia del Mombuey'), " +
                    " ( 6, 'Valencia del Ventoso'), " +
                    " ( 6, 'Valle de la Serena'), " +
                    " ( 6, 'Valle de Matamoros'), " +
                    " ( 6, 'Valle de Santa Ana'), " +
                    " ( 6, 'Valverde de Burguillos'), " +
                    " ( 6, 'Valverde de Leganés'), " +
                    " ( 6, 'Valverde de Llerena'), " +
                    " ( 6, 'Valverde de Mérida'), " +
                    " ( 6, 'Villafranca de los Barros'), " +
                    " ( 6, 'Villagarcía de la Torre'), " +
                    " ( 6, 'Villagonzalo'), " +
                    " ( 6, 'Villalba de los Barros'), " +
                    " ( 6, 'Villanueva de la Serena'), " +
                    " ( 6, 'Villanueva del Fresno'), " +
                    " ( 6, 'Villar de Rena'), " +
                    " ( 6, 'Villar del Rey'), " +
                    " ( 6, 'Villarta de los Montes'), " +
                    " ( 6, 'Zafra'), " +
                    " ( 6, 'Zahínos'), " +
                    " ( 6, 'Zalamea de la Serena'), " +
                    " ( 6, 'Zarza (La)'), " +
                    " ( 6, 'Zarza-Capilla'), " +
                    " ( 7, 'Alaior'), " +
                    " ( 7, 'Alaró'), " +
                    " ( 7, 'Alcúdia'), " +
                    " ( 7, 'Algaida'), " +
                    " ( 7, 'Andratx'), " +
                    " ( 7, 'Ariany'), " +
                    " ( 7, 'Artà'), " +
                    " ( 7, 'Banyalbufar'), " +
                    " ( 7, 'Binissalem'), " +
                    " ( 7, 'Búger'), " +
                    " ( 7, 'Bunyola'), " +
                    " ( 7, 'Calvià'), " +
                    " ( 7, 'Campanet'), " +
                    " ( 7, 'Campos'), " +
                    " ( 7, 'Capdepera'), " +
                    " ( 7, 'Castell (Es)'), " +
                    " ( 7, 'Ciutadella de Menorca'), " +
                    " ( 7, 'Consell'), " +
                    " ( 7, 'Costitx'), " +
                    " ( 7, 'Deyá'), " +
                    " ( 7, 'Eivissa'), " +
                    " ( 7, 'Escorca'), " +
                    " ( 7, 'Esporles'), " +
                    " ( 7, 'Estellencs'), " +
                    " ( 7, 'Felanitx'), " +
                    " ( 7, 'Ferreries'), " +
                    " ( 7, 'Formentera'), " +
                    " ( 7, 'Fornalutx'), " +
                    " ( 7, 'Inca'), " +
                    " ( 7, 'Lloret de Vistalegre'), " +
                    " ( 7, 'Lloseta'), " +
                    " ( 7, 'Llubí'), " +
                    " ( 7, 'Llucmajor'), " +
                    " ( 7, 'Manacor'), " +
                    " ( 7, 'Mancor de la Vall'), " +
                    " ( 7, 'Maó'), " +
                    " ( 7, 'Maria de la Salut'), " +
                    " ( 7, 'Marratxí'), " +
                    " ( 7, 'Mercadal (Es)'), " +
                    " ( 7, 'Migjorn Gran (Es)'), " +
                    " ( 7, 'Montuïri'), " +
                    " ( 7, 'Muro'), " +
                    " ( 7, 'Palma de Mallorca'), " +
                    " ( 7, 'Petra'), " +
                    " ( 7, 'Pobla (Sa)'), " +
                    " ( 7, 'Pollença'), " +
                    " ( 7, 'Porreres'), " +
                    " ( 7, 'Puigpunyent'), " +
                    " ( 7, 'Salines (Ses)'), " +
                    " ( 7, 'Sant Antoni de Portmany'), " +
                    " ( 7, 'Sant Joan'), " +
                    " ( 7, 'Sant Joan de Labritja'), " +
                    " ( 7, 'Sant Josep de sa Talaia'), " +
                    " ( 7, 'Sant Llorenç des Cardassar'), " +
                    " ( 7, 'Sant Lluís'), " +
                    " ( 7, 'Santa Eugènia'), " +
                    " ( 7, 'Santa Eulalia del Río'), " +
                    " ( 7, 'Santa Margalida'), " +
                    " ( 7, 'Santa María del Camí'), " +
                    " ( 7, 'Santanyí'), " +
                    " ( 7, 'Selva'), " +
                    " ( 7, 'Sencelles'), " +
                    " ( 7, 'Sineu'), " +
                    " ( 7, 'Sóller'), " +
                    " ( 7, 'Son Servera'), " +
                    " ( 7, 'Valldemossa'), " +
                    " ( 7, 'Vilafranca de Bonany'), " +
                    " ( 8, 'Abrera'), " +
                    " ( 8, 'Aguilar de Segarra'), " +
                    " ( 8, 'Aiguafreda'), " +
                    " ( 8, 'Alella'), " +
                    " ( 8, 'Alpens'), " +
                    " ( 8, 'Ametlla del Vallès (L'')'), " +
                    " ( 8, 'Arenys de Mar'), " +
                    " ( 8, 'Arenys de Munt'), " +
                    " ( 8, 'Argençola'), " +
                    " ( 8, 'Argentona'), " +
                    " ( 8, 'Artés'), " +
                    " ( 8, 'Avià'), " +
                    " ( 8, 'Avinyó'), " +
                    " ( 8, 'Avinyonet del Penedès'), " +
                    " ( 8, 'Badalona'), " +
                    " ( 8, 'Badia del Vallès'), " +
                    " ( 8, 'Bagà'), " +
                    " ( 8, 'Balenyà'), " +
                    " ( 8, 'Balsareny'), " +
                    " ( 8, 'Barberà del Vallès'), " +
                    " ( 8, 'Barcelona'), " +
                    " ( 8, 'Begues'), " +
                    " ( 8, 'Bellprat'), " +
                    " ( 8, 'Berga'), " +
                    " ( 8, 'Bigues i Riells'), " +
                    " ( 8, 'Borredà'), " +
                    " ( 8, 'Bruc (El)'), " +
                    " ( 8, 'Brull (El)'), " +
                    " ( 8, 'Cabanyes (Les)'), " +
                    " ( 8, 'Cabrera de Mar'), " +
                    " ( 8, 'Cabrera d''Igualada'), " +
                    " ( 8, 'Cabrils'), " +
                    " ( 8, 'Calaf'), " +
                    " ( 8, 'Calders'), " +
                    " ( 8, 'Caldes de Montbui'), " +
                    " ( 8, 'Caldes d''Estrac'), " +
                    " ( 8, 'Calella'), " +
                    " ( 8, 'Calldetenes'), " +
                    " ( 8, 'Callús'), " +
                    " ( 8, 'Calonge de Segarra'), " +
                    " ( 8, 'Campins'), " +
                    " ( 8, 'Canet de Mar'), " +
                    " ( 8, 'Canovelles'), " +
                    " ( 8, 'Cànoves i Samalús'), " +
                    " ( 8, 'Canyelles'), " +
                    " ( 8, 'Capellades'), " +
                    " ( 8, 'Capolat'), " +
                    " ( 8, 'Cardedeu'), " +
                    " ( 8, 'Cardona'), " +
                    " ( 8, 'Carme'), " +
                    " ( 8, 'Casserres'), " +
                    " ( 8, 'Castell de l''Areny'), " +
                    " ( 8, 'Castellar de n''Hug'), " +
                    " ( 8, 'Castellar del Riu'), " +
                    " ( 8, 'Castellar del Vallès'), " +
                    " ( 8, 'Castellbell i el Vilar'), " +
                    " ( 8, 'Castellbisbal'), " +
                    " ( 8, 'Castellcir'), " +
                    " ( 8, 'Castelldefels'), " +
                    " ( 8, 'Castellet i la Gornal'), " +
                    " ( 8, 'Castellfollit de Riubregós'), " +
                    " ( 8, 'Castellfollit del Boix'), " +
                    " ( 8, 'Castellgalí'), " +
                    " ( 8, 'Castellnou de Bages'), " +
                    " ( 8, 'Castellolí'), " +
                    " ( 8, 'Castellterçol'), " +
                    " ( 8, 'Castellví de la Marca'), " +
                    " ( 8, 'Castellví de Rosanes'), " +
                    " ( 8, 'Centelles'), " +
                    " ( 8, 'Cercs'), " +
                    " ( 8, 'Cerdanyola del Vallès'), " +
                    " ( 8, 'Cervelló'), " +
                    " ( 8, 'Collbató'), " +
                    " ( 8, 'Collsuspina'), " +
                    " ( 8, 'Copons'), " +
                    " ( 8, 'Corbera de Llobregat'), " +
                    " ( 8, 'Cornellà de Llobregat'), " +
                    " ( 8, 'Cubelles'), " +
                    " ( 8, 'Dosrius'), " +
                    " ( 8, 'Esparreguera'), " +
                    " ( 8, 'Esplugues de Llobregat'), " +
                    " ( 8, 'Espunyola (L'')'), " +
                    " ( 8, 'Estany (L'')'), " +
                    " ( 8, 'Figaró-Montmany'), " +
                    " ( 8, 'Fígols'), " +
                    " ( 8, 'Fogars de la Selva'), " +
                    " ( 8, 'Fogars de Montclús'), " +
                    " ( 8, 'Folgueroles'), " +
                    " ( 8, 'Fonollosa'), " +
                    " ( 8, 'Font-rubí'), " +
                    " ( 8, 'Franqueses del Vallès (Les)'), " +
                    " ( 8, 'Gaià'), " +
                    " ( 8, 'Gallifa'), " +
                    " ( 8, 'Garriga (La)'), " +
                    " ( 8, 'Gavà'), " +
                    " ( 8, 'Gelida'), " +
                    " ( 8, 'Gironella'), " +
                    " ( 8, 'Gisclareny'), " +
                    " ( 8, 'Granada (La)'), " +
                    " ( 8, 'Granera'), " +
                    " ( 8, 'Granollers'), " +
                    " ( 8, 'Gualba'), " +
                    " ( 8, 'Guardiola de Berguedà'), " +
                    " ( 8, 'Gurb'), " +
                    " ( 8, 'Hospitalet de Llobregat (L'')'), " +
                    " ( 8, 'Hostalets de Pierola (Els)'), " +
                    " ( 8, 'Igualada'), " +
                    " ( 8, 'Jorba'), " +
                    " ( 8, 'Llacuna (La)'), " +
                    " ( 8, 'Llagosta (La)'), " +
                    " ( 8, 'Lliçà d''Amunt'), " +
                    " ( 8, 'Lliçà de Vall'), " +
                    " ( 8, 'Llinars del Vallès'), " +
                    " ( 8, 'Lluçà'), " +
                    " ( 8, 'Malgrat de Mar'), " +
                    " ( 8, 'Malla'), " +
                    " ( 8, 'Manlleu'), " +
                    " ( 8, 'Manresa'), " +
                    " ( 8, 'Marganell'), " +
                    " ( 8, 'Martorell'), " +
                    " ( 8, 'Martorelles'), " +
                    " ( 8, 'Masies de Roda (Les)'), " +
                    " ( 8, 'Masies de Voltregà (Les)'), " +
                    " ( 8, 'Masnou (El)'), " +
                    " ( 8, 'Masquefa'), " +
                    " ( 8, 'Matadepera'), " +
                    " ( 8, 'Mataró'), " +
                    " ( 8, 'Mediona'), " +
                    " ( 8, 'Moià'), " +
                    " ( 8, 'Molins de Rei'), " +
                    " ( 8, 'Mollet del Vallès'), " +
                    " ( 8, 'Monistrol de Calders'), " +
                    " ( 8, 'Monistrol de Montserrat'), " +
                    " ( 8, 'Montcada i Reixac'), " +
                    " ( 8, 'Montclar'), " +
                    " ( 8, 'Montesquiu'), " +
                    " ( 8, 'Montgat'), " +
                    " ( 8, 'Montmajor'), " +
                    " ( 8, 'Montmaneu'), " +
                    " ( 8, 'Montmeló'), " +
                    " ( 8, 'Montornès del Vallès'), " +
                    " ( 8, 'Montseny'), " +
                    " ( 8, 'Muntanyola'), " +
                    " ( 8, 'Mura'), " +
                    " ( 8, 'Navarcles'), " +
                    " ( 8, 'Navàs'), " +
                    " ( 8, 'Nou de Berguedà (La)'), " +
                    " ( 8, 'Òdena'), " +
                    " ( 8, 'Olèrdola'), " +
                    " ( 8, 'Olesa de Bonesvalls'), " +
                    " ( 8, 'Olesa de Montserrat'), " +
                    " ( 8, 'Olivella'), " +
                    " ( 8, 'Olost'), " +
                    " ( 8, 'Olvan'), " +
                    " ( 8, 'Orís'), " +
                    " ( 8, 'Oristà'), " +
                    " ( 8, 'Orpí'), " +
                    " ( 8, 'Òrrius'), " +
                    " ( 8, 'Pacs del Penedès'), " +
                    " ( 8, 'Palafolls'), " +
                    " ( 8, 'Palau-solità i Plegamans'), " +
                    " ( 8, 'Pallejà'), " +
                    " ( 8, 'Palma de Cervelló (La)'), " +
                    " ( 8, 'Papiol (El)'), " +
                    " ( 8, 'Parets del Vallès'), " +
                    " ( 8, 'Perafita'), " +
                    " ( 8, 'Piera'), " +
                    " ( 8, 'Pineda de Mar'), " +
                    " ( 8, 'Pla del Penedès (El)'), " +
                    " ( 8, 'Pobla de Claramunt (La)'), " +
                    " ( 8, 'Pobla de Lillet (La)'), " +
                    " ( 8, 'Polinyà'), " +
                    " ( 8, 'Pont de Vilomara i Rocafort (El)'), " +
                    " ( 8, 'Pontons'), " +
                    " ( 8, 'Prat de Llobregat (El)'), " +
                    " ( 8, 'Prats de Lluçanès'), " +
                    " ( 8, 'Prats de Rei (Els)'), " +
                    " ( 8, 'Premià de Dalt'), " +
                    " ( 8, 'Premià de Mar'), " +
                    " ( 8, 'Puigdàlber'), " +
                    " ( 8, 'Puig-reig'), " +
                    " ( 8, 'Pujalt'), " +
                    " ( 8, 'Quar (La)'), " +
                    " ( 8, 'Rajadell'), " +
                    " ( 8, 'Rellinars'), " +
                    " ( 8, 'Ripollet'), " +
                    " ( 8, 'Roca del Vallès (La)'), " +
                    " ( 8, 'Roda de Ter'), " +
                    " ( 8, 'Rubí'), " +
                    " ( 8, 'Rubió'), " +
                    " ( 8, 'Rupit i Pruit'), " +
                    " ( 8, 'Sabadell'), " +
                    " ( 8, 'Sagàs'), " +
                    " ( 8, 'Saldes'), " +
                    " ( 8, 'Sallent'), " +
                    " ( 8, 'Sant Adrià de Besòs'), " +
                    " ( 8, 'Sant Agustí de Lluçanès'), " +
                    " ( 8, 'Sant Andreu de la Barca'), " +
                    " ( 8, 'Sant Andreu de Llavaneres'), " +
                    " ( 8, 'Sant Antoni de Vilamajor'), " +
                    " ( 8, 'Sant Bartomeu del Grau'), " +
                    " ( 8, 'Sant Boi de Llobregat'), " +
                    " ( 8, 'Sant Boi de Lluçanès'), " +
                    " ( 8, 'Sant Cebrià de Vallalta'), " +
                    " ( 8, 'Sant Celoni'), " +
                    " ( 8, 'Sant Climent de Llobregat'), " +
                    " ( 8, 'Sant Cugat del Vallès'), " +
                    " ( 8, 'Sant Cugat Sesgarrigues'), " +
                    " ( 8, 'Sant Esteve de Palautordera'), " +
                    " ( 8, 'Sant Esteve Sesrovires'), " +
                    " ( 8, 'Sant Feliu de Codines'), " +
                    " ( 8, 'Sant Feliu de Llobregat'), " +
                    " ( 8, 'Sant Feliu Sasserra'), " +
                    " ( 8, 'Sant Fost de Campsentelles'), " +
                    " ( 8, 'Sant Fruitós de Bages'), " +
                    " ( 8, 'Sant Hipòlit de Voltregà'), " +
                    " ( 8, 'Sant Iscle de Vallalta'), " +
                    " ( 8, 'Sant Jaume de Frontanyà'), " +
                    " ( 8, 'Sant Joan de Vilatorrada'), " +
                    " ( 8, 'Sant Joan Despí'), " +
                    " ( 8, 'Sant Julià de Cerdanyola'), " +
                    " ( 8, 'Sant Julià de Vilatorta'), " +
                    " ( 8, 'Sant Just Desvern'), " +
                    " ( 8, 'Sant Llorenç d''Hortons'), " +
                    " ( 8, 'Sant Llorenç Savall'), " +
                    " ( 8, 'Sant Martí d''Albars'), " +
                    " ( 8, 'Sant Martí de Centelles'), " +
                    " ( 8, 'Sant Martí de Tous'), " +
                    " ( 8, 'Sant Martí Sarroca'), " +
                    " ( 8, 'Sant Martí Sesgueioles'), " +
                    " ( 8, 'Sant Mateu de Bages'), " +
                    " ( 8, 'Sant Pere de Ribes'), " +
                    " ( 8, 'Sant Pere de Riudebitlles'), " +
                    " ( 8, 'Sant Pere de Torelló'), " +
                    " ( 8, 'Sant Pere de Vilamajor'), " +
                    " ( 8, 'Sant Pere Sallavinera'), " +
                    " ( 8, 'Sant Pol de Mar'), " +
                    " ( 8, 'Sant Quintí de Mediona'), " +
                    " ( 8, 'Sant Quirze de Besora'), " +
                    " ( 8, 'Sant Quirze del Vallès'), " +
                    " ( 8, 'Sant Quirze Safaja'), " +
                    " ( 8, 'Sant Sadurní d''Anoia'), " +
                    " ( 8, 'Sant Sadurní d''Osormort'), " +
                    " ( 8, 'Sant Salvador de Guardiola'), " +
                    " ( 8, 'Sant Vicenç de Castellet'), " +
                    " ( 8, 'Sant Vicenç de Montalt'), " +
                    " ( 8, 'Sant Vicenç de Torelló'), " +
                    " ( 8, 'Sant Vicenç dels Horts'), " +
                    " ( 8, 'Santa Cecília de Voltregà'), " +
                    " ( 8, 'Santa Coloma de Cervelló'), " +
                    " ( 8, 'Santa Coloma de Gramenet'), " +
                    " ( 8, 'Santa Eugènia de Berga'), " +
                    " ( 8, 'Santa Eulàlia de Riuprimer'), " +
                    " ( 8, 'Santa Eulàlia de Ronçana'), " +
                    " ( 8, 'Santa Fe del Penedès'), " +
                    " ( 8, 'Santa Margarida de Montbui'), " +
                    " ( 8, 'Santa Margarida i els Monjos'), " +
                    " ( 8, 'Santa Maria de Besora'), " +
                    " ( 8, 'Santa Maria de Corcó'), " +
                    " ( 8, 'Santa Maria de Martorelles'), " +
                    " ( 8, 'Santa Maria de Merlès'), " +
                    " ( 8, 'Santa Maria de Miralles'), " +
                    " ( 8, 'Santa Maria de Palautordera'), " +
                    " ( 8, 'Santa Maria d''Oló'), " +
                    " ( 8, 'Santa Perpètua de Mogoda'), " +
                    " ( 8, 'Santa Susanna'), " +
                    " ( 8, 'Santpedor'), " +
                    " ( 8, 'Sentmenat'), " +
                    " ( 8, 'Seva'), " +
                    " ( 8, 'Sitges'), " +
                    " ( 8, 'Sobremunt'), " +
                    " ( 8, 'Sora'), " +
                    " ( 8, 'Subirats'), " +
                    " ( 8, 'Súria'), " +
                    " ( 8, 'Tagamanent'), " +
                    " ( 8, 'Talamanca'), " +
                    " ( 8, 'Taradell'), " +
                    " ( 8, 'Tavèrnoles'), " +
                    " ( 8, 'Tavertet'), " +
                    " ( 8, 'Teià'), " +
                    " ( 8, 'Terrassa'), " +
                    " ( 8, 'Tiana'), " +
                    " ( 8, 'Tona'), " +
                    " ( 8, 'Tordera'), " +
                    " ( 8, 'Torelló'), " +
                    " ( 8, 'Torre de Claramunt (La)'), " +
                    " ( 8, 'Torrelavit'), " +
                    " ( 8, 'Torrelles de Foix'), " +
                    " ( 8, 'Torrelles de Llobregat'), " +
                    " ( 8, 'Ullastrell'), " +
                    " ( 8, 'Vacarisses'), " +
                    " ( 8, 'Vallbona d''Anoia'), " +
                    " ( 8, 'Vallcebre'), " +
                    " ( 8, 'Vallgorguina'), " +
                    " ( 8, 'Vallirana'), " +
                    " ( 8, 'Vallromanes'), " +
                    " ( 8, 'Veciana'), " +
                    " ( 8, 'Vic'), " +
                    " ( 8, 'Vilada'), " +
                    " ( 8, 'Viladecans'), " +
                    " ( 8, 'Viladecavalls'), " +
                    " ( 8, 'Vilafranca del Penedès'), " +
                    " ( 8, 'Vilalba Sasserra'), " +
                    " ( 8, 'Vilanova de Sau'), " +
                    " ( 8, 'Vilanova del Camí'), " +
                    " ( 8, 'Vilanova del Vallès'), " +
                    " ( 8, 'Vilanova i la Geltrú'), " +
                    " ( 8, 'Vilassar de Dalt'), " +
                    " ( 8, 'Vilassar de Mar'), " +
                    " ( 8, 'Vilobí del Penedès'), " +
                    " ( 8, 'Viver i Serrateix'), " +
                    " ( 9, 'Abajas'), " +
                    " ( 9, 'Adrada de Haza'), " +
                    " ( 9, 'Aguas Cándidas'), " +
                    " ( 9, 'Aguilar de Bureba'), " +
                    " ( 9, 'Albillos'), " +
                    " ( 9, 'Alcocero de Mola'), " +
                    " ( 9, 'Alfoz de Bricia'), " +
                    " ( 9, 'Alfoz de Quintanadueñas'), " +
                    " ( 9, 'Alfoz de Santa Gadea'), " +
                    " ( 9, 'Altable'), " +
                    " ( 9, 'Altos (Los)'), " +
                    " ( 9, 'Ameyugo'), " +
                    " ( 9, 'Anguix'), " +
                    " ( 9, 'Aranda de Duero'), " +
                    " ( 9, 'Arandilla'), " +
                    " ( 9, 'Arauzo de Miel'), " +
                    " ( 9, 'Arauzo de Salce'), " +
                    " ( 9, 'Arauzo de Torre'), " +
                    " ( 9, 'Arcos'), " +
                    " ( 9, 'Arenillas de Riopisuerga'), " +
                    " ( 9, 'Arija'), " +
                    " ( 9, 'Arlanzón'), " +
                    " ( 9, 'Arraya de Oca'), " +
                    " ( 9, 'Atapuerca'), " +
                    " ( 9, 'Ausines (Los)'), " +
                    " ( 9, 'Avellanosa de Muñó'), " +
                    " ( 9, 'Bahabón de Esgueva'), " +
                    " ( 9, 'Balbases (Los)'), " +
                    " ( 9, 'Baños de Valdearados'), " +
                    " ( 9, 'Bañuelos de Bureba'), " +
                    " ( 9, 'Barbadillo de Herreros'), " +
                    " ( 9, 'Barbadillo del Mercado'), " +
                    " ( 9, 'Barbadillo del Pez'), " +
                    " ( 9, 'Barrio de Muñó'), " +
                    " ( 9, 'Barrios de Bureba (Los)'), " +
                    " ( 9, 'Barrios de Colina'), " +
                    " ( 9, 'Basconcillos del Tozo'), " +
                    " ( 9, 'Bascuñana'), " +
                    " ( 9, 'Belbimbre'), " +
                    " ( 9, 'Belorado'), " +
                    " ( 9, 'Berberana'), " +
                    " ( 9, 'Berlangas de Roa'), " +
                    " ( 9, 'Berzosa de Bureba'), " +
                    " ( 9, 'Bozoó'), " +
                    " ( 9, 'Brazacorta'), " +
                    " ( 9, 'Briviesca'), " +
                    " ( 9, 'Bugedo'), " +
                    " ( 9, 'Buniel'), " +
                    " ( 9, 'Burgos'), " +
                    " ( 9, 'Busto de Bureba'), " +
                    " ( 9, 'Cabañes de Esgueva'), " +
                    " ( 9, 'Cabezón de la Sierra'), " +
                    " ( 9, 'Caleruega'), " +
                    " ( 9, 'Campillo de Aranda'), " +
                    " ( 9, 'Campolara'), " +
                    " ( 9, 'Canicosa de la Sierra'), " +
                    " ( 9, 'Cantabrana'), " +
                    " ( 9, 'Carazo'), " +
                    " ( 9, 'Carcedo de Bureba'), " +
                    " ( 9, 'Carcedo de Burgos'), " +
                    " ( 9, 'Cardeñadijo'), " +
                    " ( 9, 'Cardeñajimeno'), " +
                    " ( 9, 'Cardeñuela Riopico'), " +
                    " ( 9, 'Carrias'), " +
                    " ( 9, 'Cascajares de Bureba'), " +
                    " ( 9, 'Cascajares de la Sierra'), " +
                    " ( 9, 'Castellanos de Castro'), " +
                    " ( 9, 'Castil de Peones'), " +
                    " ( 9, 'Castildelgado'), " +
                    " ( 9, 'Castrillo de la Reina'), " +
                    " ( 9, 'Castrillo de la Vega'), " +
                    " ( 9, 'Castrillo de Riopisuerga'), " +
                    " ( 9, 'Castrillo del Val'), " +
                    " ( 9, 'Castrillo Matajudíos'), " +
                    " ( 9, 'Castrojeriz'), " +
                    " ( 9, 'Cavia'), " +
                    " ( 9, 'Cayuela'), " +
                    " ( 9, 'Cebrecos'), " +
                    " ( 9, 'Celada del Camino'), " +
                    " ( 9, 'Cerezo de Río Tirón'), " +
                    " ( 9, 'Cerratón de Juarros'), " +
                    " ( 9, 'Ciadoncha'), " +
                    " ( 9, 'Cillaperlata'), " +
                    " ( 9, 'Cilleruelo de Abajo'), " +
                    " ( 9, 'Cilleruelo de Arriba'), " +
                    " ( 9, 'Ciruelos de Cervera'), " +
                    " ( 9, 'Cogollos'), " +
                    " ( 9, 'Condado de Treviño'), " +
                    " ( 9, 'Contreras'), " +
                    " ( 9, 'Coruña del Conde'), " +
                    " ( 9, 'Covarrubias'), " +
                    " ( 9, 'Cubillo del Campo'), " +
                    " ( 9, 'Cubo de Bureba'), " +
                    " ( 9, 'Cueva de Roa (La)'), " +
                    " ( 9, 'Cuevas de San Clemente'), " +
                    " ( 9, 'Encío'), " +
                    " ( 9, 'Espinosa de Cervera'), " +
                    " ( 9, 'Espinosa de los Monteros'), " +
                    " ( 9, 'Espinosa del Camino'), " +
                    " ( 9, 'Estépar'), " +
                    " ( 9, 'Fontioso'), " +
                    " ( 9, 'Frandovínez'), " +
                    " ( 9, 'Fresneda de la Sierra Tirón'), " +
                    " ( 9, 'Fresneña'), " +
                    " ( 9, 'Fresnillo de las Dueñas'), " +
                    " ( 9, 'Fresno de Río Tirón'), " +
                    " ( 9, 'Fresno de Rodilla'), " +
                    " ( 9, 'Frías'), " +
                    " ( 9, 'Fuentebureba'), " +
                    " ( 9, 'Fuentecén'), " +
                    " ( 9, 'Fuentelcésped'), " +
                    " ( 9, 'Fuentelisendo'), " +
                    " ( 9, 'Fuentemolinos'), " +
                    " ( 9, 'Fuentenebro'), " +
                    " ( 9, 'Fuentespina'), " +
                    " ( 9, 'Galbarros'), " +
                    " ( 9, 'Gallega (La)'), " +
                    " ( 9, 'Grijalba'), " +
                    " ( 9, 'Grisaleña'), " +
                    " ( 9, 'Gumiel de Izán'), " +
                    " ( 9, 'Gumiel de Mercado'), " +
                    " ( 9, 'Hacinas'), " +
                    " ( 9, 'Haza'), " +
                    " ( 9, 'Hontanas'), " +
                    " ( 9, 'Hontangas'), " +
                    " ( 9, 'Hontoria de la Cantera'), " +
                    " ( 9, 'Hontoria de Valdearados'), " +
                    " ( 9, 'Hontoria del Pinar'), " +
                    " ( 9, 'Hormazas (Las)'), " +
                    " ( 9, 'Hornillos del Camino'), " +
                    " ( 9, 'Horra (La)'), " +
                    " ( 9, 'Hortigüela'), " +
                    " ( 9, 'Hoyales de Roa'), " +
                    " ( 9, 'Huérmeces'), " +
                    " ( 9, 'Huerta de Arriba'), " +
                    " ( 9, 'Huerta de Rey'), " +
                    " ( 9, 'Humada'), " +
                    " ( 9, 'Hurones'), " +
                    " ( 9, 'Ibeas de Juarros'), " +
                    " ( 9, 'Ibrillos'), " +
                    " ( 9, 'Iglesiarrubia'), " +
                    " ( 9, 'Iglesias'), " +
                    " ( 9, 'Isar'), " +
                    " ( 9, 'Itero del Castillo'), " +
                    " ( 9, 'Jaramillo de la Fuente'), " +
                    " ( 9, 'Jaramillo Quemado'), " +
                    " ( 9, 'Junta de Traslaloma'), " +
                    " ( 9, 'Junta de Villalba de Losa'), " +
                    " ( 9, 'Jurisdicción de Lara'), " +
                    " ( 9, 'Jurisdicción de San Zadornil'), " +
                    " ( 9, 'Lerma'), " +
                    " ( 9, 'Llano de Bureba'), " +
                    " ( 9, 'Madrigal del Monte'), " +
                    " ( 9, 'Madrigalejo del Monte'), " +
                    " ( 9, 'Mahamud'), " +
                    " ( 9, 'Mambrilla de Castrejón'), " +
                    " ( 9, 'Mambrillas de Lara'), " +
                    " ( 9, 'Mamolar'), " +
                    " ( 9, 'Manciles'), " +
                    " ( 9, 'Mazuela'), " +
                    " ( 9, 'Mecerreyes'), " +
                    " ( 9, 'Medina de Pomar'), " +
                    " ( 9, 'Melgar de Fernamental'), " +
                    " ( 9, 'Merindad de Cuesta-Urria'), " +
                    " ( 9, 'Merindad de Montija'), " +
                    " ( 9, 'Merindad de Río Ubierna'), " +
                    " ( 9, 'Merindad de Sotoscueva'), " +
                    " ( 9, 'Merindad de Valdeporres'), " +
                    " ( 9, 'Merindad de Valdivielso'), " +
                    " ( 9, 'Milagros'), " +
                    " ( 9, 'Miranda de Ebro'), " +
                    " ( 9, 'Miraveche'), " +
                    " ( 9, 'Modúbar de la Emparedada'), " +
                    " ( 9, 'Monasterio de la Sierra'), " +
                    " ( 9, 'Monasterio de Rodilla'), " +
                    " ( 9, 'Moncalvillo'), " +
                    " ( 9, 'Monterrubio de la Demanda'), " +
                    " ( 9, 'Montorio'), " +
                    " ( 9, 'Moradillo de Roa'), " +
                    " ( 9, 'Nava de Roa'), " +
                    " ( 9, 'Navas de Bureba'), " +
                    " ( 9, 'Nebreda'), " +
                    " ( 9, 'Neila'), " +
                    " ( 9, 'Olmedillo de Roa'), " +
                    " ( 9, 'Olmillos de Muñó'), " +
                    " ( 9, 'Oña'), " +
                    " ( 9, 'Oquillas'), " +
                    " ( 9, 'Orbaneja Riopico'), " +
                    " ( 9, 'Padilla de Abajo'), " +
                    " ( 9, 'Padilla de Arriba'), " +
                    " ( 9, 'Padrones de Bureba'), " +
                    " ( 9, 'Palacios de la Sierra'), " +
                    " ( 9, 'Palacios de Riopisuerga'), " +
                    " ( 9, 'Palazuelos de la Sierra'), " +
                    " ( 9, 'Palazuelos de Muñó'), " +
                    " ( 9, 'Pampliega'), " +
                    " ( 9, 'Pancorbo'), " +
                    " ( 9, 'Pardilla'), " +
                    " ( 9, 'Partido de la Sierra en Tobalina'), " +
                    " ( 9, 'Pedrosa de Duero'), " +
                    " ( 9, 'Pedrosa de Río Úrbel'), " +
                    " ( 9, 'Pedrosa del Páramo'), " +
                    " ( 9, 'Pedrosa del Príncipe'), " +
                    " ( 9, 'Peñaranda de Duero'), " +
                    " ( 9, 'Peral de Arlanza'), " +
                    " ( 9, 'Piérnigas'), " +
                    " ( 9, 'Pineda de la Sierra'), " +
                    " ( 9, 'Pineda Trasmonte'), " +
                    " ( 9, 'Pinilla de los Barruecos'), " +
                    " ( 9, 'Pinilla de los Moros'), " +
                    " ( 9, 'Pinilla Trasmonte'), " +
                    " ( 9, 'Poza de la Sal'), " +
                    " ( 9, 'Prádanos de Bureba'), " +
                    " ( 9, 'Pradoluengo'), " +
                    " ( 9, 'Presencio'), " +
                    " ( 9, 'Puebla de Arganzón (La)'), " +
                    " ( 9, 'Puentedura'), " +
                    " ( 9, 'Quemada'), " +
                    " ( 9, 'Quintana del Pidio'), " +
                    " ( 9, 'Quintanabureba'), " +
                    " ( 9, 'Quintanaélez'), " +
                    " ( 9, 'Quintanaortuño'), " +
                    " ( 9, 'Quintanapalla'), " +
                    " ( 9, 'Quintanar de la Sierra'), " +
                    " ( 9, 'Quintanavides'), " +
                    " ( 9, 'Quintanilla de la Mata'), " +
                    " ( 9, 'Quintanilla del Agua y Tordueles'), " +
                    " ( 9, 'Quintanilla del Coco'), " +
                    " ( 9, 'Quintanilla San García'), " +
                    " ( 9, 'Quintanilla Vivar'), " +
                    " ( 9, 'Quintanillas (Las)'), " +
                    " ( 9, 'Rabanera del Pinar'), " +
                    " ( 9, 'Rábanos'), " +
                    " ( 9, 'Rabé de las Calzadas'), " +
                    " ( 9, 'Rebolledo de la Torre'), " +
                    " ( 9, 'Redecilla del Camino'), " +
                    " ( 9, 'Redecilla del Campo'), " +
                    " ( 9, 'Regumiel de la Sierra'), " +
                    " ( 9, 'Reinoso'), " +
                    " ( 9, 'Retuerta'), " +
                    " ( 9, 'Revilla del Campo'), " +
                    " ( 9, 'Revilla Vallejera'), " +
                    " ( 9, 'Revilla y Ahedo (La)'), " +
                    " ( 9, 'Revillarruz'), " +
                    " ( 9, 'Rezmondo'), " +
                    " ( 9, 'Riocavado de la Sierra'), " +
                    " ( 9, 'Roa'), " +
                    " ( 9, 'Rojas'), " +
                    " ( 9, 'Royuela de Río Franco'), " +
                    " ( 9, 'Rubena'), " +
                    " ( 9, 'Rublacedo de Abajo'), " +
                    " ( 9, 'Rucandio'), " +
                    " ( 9, 'Salas de Bureba'), " +
                    " ( 9, 'Salas de los Infantes'), " +
                    " ( 9, 'Saldaña de Burgos'), " +
                    " ( 9, 'Salinillas de Bureba'), " +
                    " ( 9, 'San Adrián de Juarros'), " +
                    " ( 9, 'San Juan del Monte'), " +
                    " ( 9, 'San Mamés de Burgos'), " +
                    " ( 9, 'San Martín de Rubiales'), " +
                    " ( 9, 'San Millán de Lara'), " +
                    " ( 9, 'San Vicente del Valle'), " +
                    " ( 9, 'Santa Cecilia'), " +
                    " ( 9, 'Santa Cruz de la Salceda'), " +
                    " ( 9, 'Santa Cruz del Valle Urbión'), " +
                    " ( 9, 'Santa Gadea del Cid'), " +
                    " ( 9, 'Santa Inés'), " +
                    " ( 9, 'Santa María del Campo'), " +
                    " ( 9, 'Santa María del Invierno'), " +
                    " ( 9, 'Santa María del Mercadillo'), " +
                    " ( 9, 'Santa María Rivarredonda'), " +
                    " ( 9, 'Santa Olalla de Bureba'), " +
                    " ( 9, 'Santibáñez de Esgueva'), " +
                    " ( 9, 'Santibáñez del Val'), " +
                    " ( 9, 'Santo Domingo de Silos'), " +
                    " ( 9, 'Sargentes de la Lora'), " +
                    " ( 9, 'Sarracín'), " +
                    " ( 9, 'Sasamón'), " +
                    " ( 9, 'Sequera de Haza (La)'), " +
                    " ( 9, 'Solarana'), " +
                    " ( 9, 'Sordillos'), " +
                    " ( 9, 'Sotillo de la Ribera'), " +
                    " ( 9, 'Sotragero'), " +
                    " ( 9, 'Sotresgudo'), " +
                    " ( 9, 'Susinos del Páramo'), " +
                    " ( 9, 'Tamarón'), " +
                    " ( 9, 'Tardajos'), " +
                    " ( 9, 'Tejada'), " +
                    " ( 9, 'Terradillos de Esgueva'), " +
                    " ( 9, 'Tinieblas de la Sierra'), " +
                    " ( 9, 'Tobar'), " +
                    " ( 9, 'Tordómar'), " +
                    " ( 9, 'Torrecilla del Monte'), " +
                    " ( 9, 'Torregalindo'), " +
                    " ( 9, 'Torrelara'), " +
                    " ( 9, 'Torrepadre'), " +
                    " ( 9, 'Torresandino'), " +
                    " ( 9, 'Tórtoles de Esgueva'), " +
                    " ( 9, 'Tosantos'), " +
                    " ( 9, 'Trespaderne'), " +
                    " ( 9, 'Tubilla del Agua'), " +
                    " ( 9, 'Tubilla del Lago'), " +
                    " ( 9, 'Úrbel del Castillo'), " +
                    " ( 9, 'Vadocondes'), " +
                    " ( 9, 'Valdeande'), " +
                    " ( 9, 'Valdezate'), " +
                    " ( 9, 'Valdorros'), " +
                    " ( 9, 'Vallarta de Bureba'), " +
                    " ( 9, 'Valle de las Navas'), " +
                    " ( 9, 'Valle de Losa'), " +
                    " ( 9, 'Valle de Manzanedo'), " +
                    " ( 9, 'Valle de Mena'), " +
                    " ( 9, 'Valle de Oca'), " +
                    " ( 9, 'Valle de Santibáñez'), " +
                    " ( 9, 'Valle de Sedano'), " +
                    " ( 9, 'Valle de Tobalina'), " +
                    " ( 9, 'Valle de Valdebezana'), " +
                    " ( 9, 'Valle de Valdelaguna'), " +
                    " ( 9, 'Valle de Valdelucio'), " +
                    " ( 9, 'Valle de Zamanzas'), " +
                    " ( 9, 'Vallejera'), " +
                    " ( 9, 'Valles de Palenzuela'), " +
                    " ( 9, 'Valluércanes'), " +
                    " ( 9, 'Valmala'), " +
                    " ( 9, 'Vid de Bureba (La)'), " +
                    " ( 9, 'Vid y Barrios (La)'), " +
                    " ( 9, 'Vileña'), " +
                    " ( 9, 'Villadiego'), " +
                    " ( 9, 'Villaescusa de Roa'), " +
                    " ( 9, 'Villaescusa la Sombría'), " +
                    " ( 9, 'Villaespasa'), " +
                    " ( 9, 'Villafranca Montes de Oca'), " +
                    " ( 9, 'Villafruela'), " +
                    " ( 9, 'Villagalijo'), " +
                    " ( 9, 'Villagonzalo Pedernales'), " +
                    " ( 9, 'Villahoz'), " +
                    " ( 9, 'Villalba de Duero'), " +
                    " ( 9, 'Villalbilla de Burgos'), " +
                    " ( 9, 'Villalbilla de Gumiel'), " +
                    " ( 9, 'Villaldemiro'), " +
                    " ( 9, 'Villalmanzo'), " +
                    " ( 9, 'Villamayor de los Montes'), " +
                    " ( 9, 'Villamayor de Treviño'), " +
                    " ( 9, 'Villambistia'), " +
                    " ( 9, 'Villamedianilla'), " +
                    " ( 9, 'Villamiel de la Sierra'), " +
                    " ( 9, 'Villangómez'), " +
                    " ( 9, 'Villanueva de Argaño'), " +
                    " ( 9, 'Villanueva de Carazo'), " +
                    " ( 9, 'Villanueva de Gumiel'), " +
                    " ( 9, 'Villanueva de Teba'), " +
                    " ( 9, 'Villaquirán de la Puebla'), " +
                    " ( 9, 'Villaquirán de los Infantes'), " +
                    " ( 9, 'Villarcayo de Merindad de Castilla la Vieja'), " +
                    " ( 9, 'Villariezo'), " +
                    " ( 9, 'Villasandino'), " +
                    " ( 9, 'Villasur de Herreros'), " +
                    " ( 9, 'Villatuelda'), " +
                    " ( 9, 'Villaverde del Monte'), " +
                    " ( 9, 'Villaverde-Mogina'), " +
                    " ( 9, 'Villayerno Morquillas'), " +
                    " ( 9, 'Villazopeque'), " +
                    " ( 9, 'Villegas'), " +
                    " ( 9, 'Villoruebo'), " +
                    " ( 9, 'Viloria de Rioja'), " +
                    " ( 9, 'Vilviestre del Pinar'), " +
                    " ( 9, 'Vizcaínos'), " +
                    " ( 9, 'Zael'), " +
                    " ( 9, 'Zarzosa de Río Pisuerga'), " +
                    " ( 9, 'Zazuar'), " +
                    " ( 9, 'Zuñeda'), " +
                    " ( 10, 'Abadía'), " +
                    " ( 10, 'Abertura'), " +
                    " ( 10, 'Acebo'), " +
                    " ( 10, 'Acehúche'), " +
                    " ( 10, 'Aceituna'), " +
                    " ( 10, 'Ahigal'), " +
                    " ( 10, 'Albalá'), " +
                    " ( 10, 'Alcántara'), " +
                    " ( 10, 'Alcollarín'), " +
                    " ( 10, 'Alcuéscar'), " +
                    " ( 10, 'Aldea del Cano'), " +
                    " ( 10, 'Aldea del Obispo (La)'), " +
                    " ( 10, 'Aldeacentenera'), " +
                    " ( 10, 'Aldeanueva de la Vera'), " +
                    " ( 10, 'Aldeanueva del Camino'), " +
                    " ( 10, 'Aldehuela de Jerte'), " +
                    " ( 10, 'Alía'), " +
                    " ( 10, 'Aliseda'), " +
                    " ( 10, 'Almaraz'), " +
                    " ( 10, 'Almoharín'), " +
                    " ( 10, 'Arroyo de la Luz'), " +
                    " ( 10, 'Arroyomolinos'), " +
                    " ( 10, 'Arroyomolinos de la Vera'), " +
                    " ( 10, 'Baños de Montemayor'), " +
                    " ( 10, 'Barrado'), " +
                    " ( 10, 'Belvís de Monroy'), " +
                    " ( 10, 'Benquerencia'), " +
                    " ( 10, 'Berrocalejo'), " +
                    " ( 10, 'Berzocana'), " +
                    " ( 10, 'Bohonal de Ibor'), " +
                    " ( 10, 'Botija'), " +
                    " ( 10, 'Brozas'), " +
                    " ( 10, 'Cabañas del Castillo'), " +
                    " ( 10, 'Cabezabellosa'), " +
                    " ( 10, 'Cabezuela del Valle'), " +
                    " ( 10, 'Cabrero'), " +
                    " ( 10, 'Cáceres'), " +
                    " ( 10, 'Cachorrilla'), " +
                    " ( 10, 'Cadalso'), " +
                    " ( 10, 'Calzadilla'), " +
                    " ( 10, 'Caminomorisco'), " +
                    " ( 10, 'Campillo de Deleitosa'), " +
                    " ( 10, 'Campo Lugar'), " +
                    " ( 10, 'Cañamero'), " +
                    " ( 10, 'Cañaveral'), " +
                    " ( 10, 'Carbajo'), " +
                    " ( 10, 'Carcaboso'), " +
                    " ( 10, 'Carrascalejo'), " +
                    " ( 10, 'Casar de Cáceres'), " +
                    " ( 10, 'Casar de Palomero'), " +
                    " ( 10, 'Casares de las Hurdes'), " +
                    " ( 10, 'Casas de Don Antonio'), " +
                    " ( 10, 'Casas de Don Gómez'), " +
                    " ( 10, 'Casas de Millán'), " +
                    " ( 10, 'Casas de Miravete'), " +
                    " ( 10, 'Casas del Castañar'), " +
                    " ( 10, 'Casas del Monte'), " +
                    " ( 10, 'Casatejada'), " +
                    " ( 10, 'Casillas de Coria'), " +
                    " ( 10, 'Castañar de Ibor'), " +
                    " ( 10, 'Ceclavín'), " +
                    " ( 10, 'Cedillo'), " +
                    " ( 10, 'Cerezo'), " +
                    " ( 10, 'Cilleros'), " +
                    " ( 10, 'Collado'), " +
                    " ( 10, 'Conquista de la Sierra'), " +
                    " ( 10, 'Coria'), " +
                    " ( 10, 'Cuacos de Yuste'), " +
                    " ( 10, 'Cumbre (La)'), " +
                    " ( 10, 'Deleitosa'), " +
                    " ( 10, 'Descargamaría'), " +
                    " ( 10, 'Eljas'), " +
                    " ( 10, 'Escurial'), " +
                    " ( 10, 'Fresnedoso de Ibor'), " +
                    " ( 10, 'Galisteo'), " +
                    " ( 10, 'Garciaz'), " +
                    " ( 10, 'Garganta (La)'), " +
                    " ( 10, 'Garganta la Olla'), " +
                    " ( 10, 'Gargantilla'), " +
                    " ( 10, 'Gargüera'), " +
                    " ( 10, 'Garrovillas de Alconétar'), " +
                    " ( 10, 'Garvín'), " +
                    " ( 10, 'Gata'), " +
                    " ( 10, 'Gordo (El)'), " +
                    " ( 10, 'Granja (La)'), " +
                    " ( 10, 'Guadalupe'), " +
                    " ( 10, 'Guijo de Coria'), " +
                    " ( 10, 'Guijo de Galisteo'), " +
                    " ( 10, 'Guijo de Granadilla'), " +
                    " ( 10, 'Guijo de Santa Bárbara'), " +
                    " ( 10, 'Herguijuela'), " +
                    " ( 10, 'Hernán-Pérez'), " +
                    " ( 10, 'Herrera de Alcántara'), " +
                    " ( 10, 'Herreruela'), " +
                    " ( 10, 'Hervás'), " +
                    " ( 10, 'Higuera'), " +
                    " ( 10, 'Hinojal'), " +
                    " ( 10, 'Holguera'), " +
                    " ( 10, 'Hoyos'), " +
                    " ( 10, 'Huélaga'), " +
                    " ( 10, 'Ibahernando'), " +
                    " ( 10, 'Jaraicejo'), " +
                    " ( 10, 'Jaraíz de la Vera'), " +
                    " ( 10, 'Jarandilla de la Vera'), " +
                    " ( 10, 'Jarilla'), " +
                    " ( 10, 'Jerte'), " +
                    " ( 10, 'Ladrillar'), " +
                    " ( 10, 'Logrosán'), " +
                    " ( 10, 'Losar de la Vera'), " +
                    " ( 10, 'Madrigal de la Vera'), " +
                    " ( 10, 'Madrigalejo'), " +
                    " ( 10, 'Madroñera'), " +
                    " ( 10, 'Majadas'), " +
                    " ( 10, 'Malpartida de Cáceres'), " +
                    " ( 10, 'Malpartida de Plasencia'), " +
                    " ( 10, 'Marchagaz'), " +
                    " ( 10, 'Mata de Alcántara'), " +
                    " ( 10, 'Membrío'), " +
                    " ( 10, 'Mesas de Ibor'), " +
                    " ( 10, 'Miajadas'), " +
                    " ( 10, 'Millanes'), " +
                    " ( 10, 'Mirabel'), " +
                    " ( 10, 'Mohedas de Granadilla'), " +
                    " ( 10, 'Monroy'), " +
                    " ( 10, 'Montánchez'), " +
                    " ( 10, 'Montehermoso'), " +
                    " ( 10, 'Moraleja'), " +
                    " ( 10, 'Morcillo'), " +
                    " ( 10, 'Navaconcejo'), " +
                    " ( 10, 'Navalmoral de la Mata'), " +
                    " ( 10, 'Navalvillar de Ibor'), " +
                    " ( 10, 'Navas del Madroño'), " +
                    " ( 10, 'Navezuelas'), " +
                    " ( 10, 'Nuñomoral'), " +
                    " ( 10, 'Oliva de Plasencia'), " +
                    " ( 10, 'Palomero'), " +
                    " ( 10, 'Pasarón de la Vera'), " +
                    " ( 10, 'Pedroso de Acim'), " +
                    " ( 10, 'Peraleda de la Mata'), " +
                    " ( 10, 'Peraleda de San Román'), " +
                    " ( 10, 'Perales del Puerto'), " +
                    " ( 10, 'Pescueza'), " +
                    " ( 10, 'Pesga (La)'), " +
                    " ( 10, 'Piedras Albas'), " +
                    " ( 10, 'Pinofranqueado'), " +
                    " ( 10, 'Piornal'), " +
                    " ( 10, 'Plasencia'), " +
                    " ( 10, 'Plasenzuela'), " +
                    " ( 10, 'Portaje'), " +
                    " ( 10, 'Portezuelo'), " +
                    " ( 10, 'Pozuelo de Zarzón'), " +
                    " ( 10, 'Puerto de Santa Cruz'), " +
                    " ( 10, 'Rebollar'), " +
                    " ( 10, 'Riolobos'), " +
                    " ( 10, 'Robledillo de Gata'), " +
                    " ( 10, 'Robledillo de la Vera'), " +
                    " ( 10, 'Robledillo de Trujillo'), " +
                    " ( 10, 'Robledollano'), " +
                    " ( 10, 'Romangordo'), " +
                    " ( 10, 'Rosalejo'), " +
                    " ( 10, 'Ruanes'), " +
                    " ( 10, 'Salorino'), " +
                    " ( 10, 'Salvatierra de Santiago'), " +
                    " ( 10, 'San Martín de Trevejo'), " +
                    " ( 10, 'Santa Ana'), " +
                    " ( 10, 'Santa Cruz de la Sierra'), " +
                    " ( 10, 'Santa Cruz de Paniagua'), " +
                    " ( 10, 'Santa Marta de Magasca'), " +
                    " ( 10, 'Santiago de Alcántara'), " +
                    " ( 10, 'Santiago del Campo'), " +
                    " ( 10, 'Santibáñez el Alto'), " +
                    " ( 10, 'Santibáñez el Bajo'), " +
                    " ( 10, 'Saucedilla'), " +
                    " ( 10, 'Segura de Toro'), " +
                    " ( 10, 'Serradilla'), " +
                    " ( 10, 'Serrejón'), " +
                    " ( 10, 'Sierra de Fuentes'), " +
                    " ( 10, 'Talaván'), " +
                    " ( 10, 'Talaveruela de la Vera'), " +
                    " ( 10, 'Talayuela'), " +
                    " ( 10, 'Tejeda de Tiétar'), " +
                    " ( 10, 'Toril'), " +
                    " ( 10, 'Tornavacas'), " +
                    " ( 10, 'Torno (El)'), " +
                    " ( 10, 'Torre de Don Miguel'), " +
                    " ( 10, 'Torre de Santa María'), " +
                    " ( 10, 'Torrecilla de los Ángeles'), " +
                    " ( 10, 'Torrecillas de la Tiesa'), " +
                    " ( 10, 'Torrejón el Rubio'), " +
                    " ( 10, 'Torrejoncillo'), " +
                    " ( 10, 'Torremenga'), " +
                    " ( 10, 'Torremocha'), " +
                    " ( 10, 'Torreorgaz'), " +
                    " ( 10, 'Torrequemada'), " +
                    " ( 10, 'Trujillo'), " +
                    " ( 10, 'Valdastillas'), " +
                    " ( 10, 'Valdecañas de Tajo'), " +
                    " ( 10, 'Valdefuentes'), " +
                    " ( 10, 'Valdehúncar'), " +
                    " ( 10, 'Valdelacasa de Tajo'), " +
                    " ( 10, 'Valdemorales'), " +
                    " ( 10, 'Valdeobispo'), " +
                    " ( 10, 'Valencia de Alcántara'), " +
                    " ( 10, 'Valverde de la Vera'), " +
                    " ( 10, 'Valverde del Fresno'), " +
                    " ( 10, 'Viandar de la Vera'), " +
                    " ( 10, 'Villa del Campo'), " +
                    " ( 10, 'Villa del Rey'), " +
                    " ( 10, 'Villamesías'), " +
                    " ( 10, 'Villamiel'), " +
                    " ( 10, 'Villanueva de la Sierra'), " +
                    " ( 10, 'Villanueva de la Vera'), " +
                    " ( 10, 'Villar de Plasencia'), " +
                    " ( 10, 'Villar del Pedroso'), " +
                    " ( 10, 'Villasbuenas de Gata'), " +
                    " ( 10, 'Zarza de Granadilla'), " +
                    " ( 10, 'Zarza de Montánchez'), " +
                    " ( 10, 'Zarza la Mayor'), " +
                    " ( 10, 'Zorita'), " +
                    " ( 11, 'Alcalá de los Gazules'), " +
                    " ( 11, 'Alcalá del Valle'), " +
                    " ( 11, 'Algar'), " +
                    " ( 11, 'Algeciras'), " +
                    " ( 11, 'Algodonales'), " +
                    " ( 11, 'Arcos de la Frontera'), " +
                    " ( 11, 'Barbate'), " +
                    " ( 11, 'Barrios (Los)'), " +
                    " ( 11, 'Benalup-Casas Viejas'), " +
                    " ( 11, 'Benaocaz'), " +
                    " ( 11, 'Bornos'), " +
                    " ( 11, 'Bosque (El)'), " +
                    " ( 11, 'Cádiz'), " +
                    " ( 11, 'Castellar de la Frontera'), " +
                    " ( 11, 'Chiclana de la Frontera'), " +
                    " ( 11, 'Chipiona'), " +
                    " ( 11, 'Conil de la Frontera'), " +
                    " ( 11, 'Espera'), " +
                    " ( 11, 'Gastor (El)'), " +
                    " ( 11, 'Grazalema'), " +
                    " ( 11, 'Jerez de la Frontera'), " +
                    " ( 11, 'Jimena de la Frontera'), " +
                    " ( 11, 'Línea de la Concepción (La)'), " +
                    " ( 11, 'Medina-Sidonia'), " +
                    " ( 11, 'Olvera'), " +
                    " ( 11, 'Paterna de Rivera'), " +
                    " ( 11, 'Prado del Rey'), " +
                    " ( 11, 'Puerto de Santa María (El)'), " +
                    " ( 11, 'Puerto Real'), " +
                    " ( 11, 'Puerto Serrano'), " +
                    " ( 11, 'Rota'), " +
                    " ( 11, 'San Fernando'), " +
                    " ( 11, 'San José del Valle'), " +
                    " ( 11, 'San Roque'), " +
                    " ( 11, 'Sanlúcar de Barrameda'), " +
                    " ( 11, 'Setenil de las Bodegas'), " +
                    " ( 11, 'Tarifa'), " +
                    " ( 11, 'Torre Alháquime'), " +
                    " ( 11, 'Trebujena'), " +
                    " ( 11, 'Ubrique'), " +
                    " ( 11, 'Vejer de la Frontera'), " +
                    " ( 11, 'Villaluenga del Rosario'), " +
                    " ( 11, 'Villamartín'), " +
                    " ( 11, 'Zahara'), " +
                    " ( 12, 'Aín'), " +
                    " ( 12, 'Albocàsser'), " +
                    " ( 12, 'Alcalà de Xivert'), " +
                    " ( 12, 'Alcora (l'')'), " +
                    " ( 12, 'Alcudia de Veo'), " +
                    " ( 12, 'Alfondeguilla'), " +
                    " ( 12, 'Algimia de Almonacid'), " +
                    " ( 12, 'Almazora/Almassora'), " +
                    " ( 12, 'Almedíjar'), " +
                    " ( 12, 'Almenara'), " +
                    " ( 12, 'Alquerías del Niño Perdido'), " +
                    " ( 12, 'Altura'), " +
                    " ( 12, 'Arañuel'), " +
                    " ( 12, 'Ares del Maestre'), " +
                    " ( 12, 'Argelita'), " +
                    " ( 12, 'Artana'), " +
                    " ( 12, 'Atzeneta del Maestrat'), " +
                    " ( 12, 'Ayódar'), " +
                    " ( 12, 'Azuébar'), " +
                    " ( 12, 'Barracas'), " +
                    " ( 12, 'Bejís'), " +
                    " ( 12, 'Benafer'), " +
                    " ( 12, 'Benafigos'), " +
                    " ( 12, 'Benasal'), " +
                    " ( 12, 'Benicarló'), " +
                    " ( 12, 'Benicasim/Benicàssim'), " +
                    " ( 12, 'Benlloch'), " +
                    " ( 12, 'Betxí'), " +
                    " ( 12, 'Borriol'), " +
                    " ( 12, 'Burriana'), " +
                    " ( 12, 'Cabanes'), " +
                    " ( 12, 'Càlig'), " +
                    " ( 12, 'Canet lo Roig'), " +
                    " ( 12, 'Castell de Cabres'), " +
                    " ( 12, 'Castellfort'), " +
                    " ( 12, 'Castellnovo'), " +
                    " ( 12, 'Castellón de la Plana/Castelló de la Plana'), " +
                    " ( 12, 'Castillo de Villamalefa'), " +
                    " ( 12, 'Catí'), " +
                    " ( 12, 'Caudiel'), " +
                    " ( 12, 'Cervera del Maestre'), " +
                    " ( 12, 'Chert/Xert'), " +
                    " ( 12, 'Chilches/Xilxes'), " +
                    " ( 12, 'Chodos/Xodos'), " +
                    " ( 12, 'Chóvar'), " +
                    " ( 12, 'Cinctorres'), " +
                    " ( 12, 'Cirat'), " +
                    " ( 12, 'Cortes de Arenoso'), " +
                    " ( 12, 'Costur'), " +
                    " ( 12, 'Coves de Vinromà (les)'), " +
                    " ( 12, 'Culla'), " +
                    " ( 12, 'Eslida'), " +
                    " ( 12, 'Espadilla'), " +
                    " ( 12, 'Fanzara'), " +
                    " ( 12, 'Figueroles'), " +
                    " ( 12, 'Forcall'), " +
                    " ( 12, 'Fuente la Reina'), " +
                    " ( 12, 'Fuentes de Ayódar'), " +
                    " ( 12, 'Gaibiel'), " +
                    " ( 12, 'Geldo'), " +
                    " ( 12, 'Herbés'), " +
                    " ( 12, 'Higueras'), " +
                    " ( 12, 'Jana (la)'), " +
                    " ( 12, 'Jérica'), " +
                    " ( 12, 'Llosa (la)'), " +
                    " ( 12, 'Lucena del Cid'), " +
                    " ( 12, 'Ludiente'), " +
                    " ( 12, 'Mata de Morella (la)'), " +
                    " ( 12, 'Matet'), " +
                    " ( 12, 'Moncofa'), " +
                    " ( 12, 'Montán'), " +
                    " ( 12, 'Montanejos'), " +
                    " ( 12, 'Morella'), " +
                    " ( 12, 'Navajas'), " +
                    " ( 12, 'Nules'), " +
                    " ( 12, 'Olocau del Rey'), " +
                    " ( 12, 'Onda'), " +
                    " ( 12, 'Oropesa del Mar/Orpesa'), " +
                    " ( 12, 'Palanques'), " +
                    " ( 12, 'Pavías'), " +
                    " ( 12, 'Peñíscola'), " +
                    " ( 12, 'Pina de Montalgrao'), " +
                    " ( 12, 'Pobla de Benifassà (la)'), " +
                    " ( 12, 'Pobla Tornesa (la)'), " +
                    " ( 12, 'Portell de Morella'), " +
                    " ( 12, 'Puebla de Arenoso'), " +
                    " ( 12, 'Ribesalbes'), " +
                    " ( 12, 'Rossell'), " +
                    " ( 12, 'Sacañet'), " +
                    " ( 12, 'Salzadella (la)'), " +
                    " ( 12, 'San Rafael del Río'), " +
                    " ( 12, 'Sant Joan de Moró'), " +
                    " ( 12, 'Sant Jordi/San Jorge'), " +
                    " ( 12, 'Sant Mateu'), " +
                    " ( 12, 'Santa Magdalena de Pulpis'), " +
                    " ( 12, 'Sarratella'), " +
                    " ( 12, 'Segorbe'), " +
                    " ( 12, 'Sierra Engarcerán'), " +
                    " ( 12, 'Soneja'), " +
                    " ( 12, 'Sot de Ferrer'), " +
                    " ( 12, 'Sueras/Suera'), " +
                    " ( 12, 'Tales'), " +
                    " ( 12, 'Teresa'), " +
                    " ( 12, 'Tírig'), " +
                    " ( 12, 'Todolella'), " +
                    " ( 12, 'Toga'), " +
                    " ( 12, 'Torás'), " +
                    " ( 12, 'Toro (El)'), " +
                    " ( 12, 'Torralba del Pinar'), " +
                    " ( 12, 'Torre d''En Besora (la)'), " +
                    " ( 12, 'Torre Endoménech'), " +
                    " ( 12, 'Torreblanca'), " +
                    " ( 12, 'Torrechiva'), " +
                    " ( 12, 'Traiguera'), " +
                    " ( 12, 'Useras/Useres (les)'), " +
                    " ( 12, 'Vall d''Alba'), " +
                    " ( 12, 'Vall de Almonacid'), " +
                    " ( 12, 'Vall d''Uixó (la)'), " +
                    " ( 12, 'Vallat'), " +
                    " ( 12, 'Vallibona'), " +
                    " ( 12, 'Vilafamés'), " +
                    " ( 12, 'Vilanova d''Alcolea'), " +
                    " ( 12, 'Vilar de Canes'), " +
                    " ( 12, 'Vila-real'), " +
                    " ( 12, 'Vilavella (la)'), " +
                    " ( 12, 'Villafranca del Cid/Vilafranca'), " +
                    " ( 12, 'Villahermosa del Río'), " +
                    " ( 12, 'Villamalur'), " +
                    " ( 12, 'Villanueva de Viver'), " +
                    " ( 12, 'Villores'), " +
                    " ( 12, 'Vinaròs'), " +
                    " ( 12, 'Vistabella del Maestrazgo'), " +
                    " ( 12, 'Viver'), " +
                    " ( 12, 'Zorita del Maestrazgo'), " +
                    " ( 12, 'Zucaina'), " +
                    " ( 13, 'Abenójar'), " +
                    " ( 13, 'Agudo'), " +
                    " ( 13, 'Alamillo'), " +
                    " ( 13, 'Albaladejo'), " +
                    " ( 13, 'Alcázar de San Juan'), " +
                    " ( 13, 'Alcoba'), " +
                    " ( 13, 'Alcolea de Calatrava'), " +
                    " ( 13, 'Alcubillas'), " +
                    " ( 13, 'Aldea del Rey'), " +
                    " ( 13, 'Alhambra'), " +
                    " ( 13, 'Almadén'), " +
                    " ( 13, 'Almadenejos'), " +
                    " ( 13, 'Almagro'), " +
                    " ( 13, 'Almedina'), " +
                    " ( 13, 'Almodóvar del Campo'), " +
                    " ( 13, 'Almuradiel'), " +
                    " ( 13, 'Anchuras'), " +
                    " ( 13, 'Arenales de San Gregorio'), " +
                    " ( 13, 'Arenas de San Juan'), " +
                    " ( 13, 'Argamasilla de Alba'), " +
                    " ( 13, 'Argamasilla de Calatrava'), " +
                    " ( 13, 'Arroba de los Montes'), " +
                    " ( 13, 'Ballesteros de Calatrava'), " +
                    " ( 13, 'Bolaños de Calatrava'), " +
                    " ( 13, 'Brazatortas'), " +
                    " ( 13, 'Cabezarados'), " +
                    " ( 13, 'Cabezarrubias del Puerto'), " +
                    " ( 13, 'Calzada de Calatrava'), " +
                    " ( 13, 'Campo de Criptana'), " +
                    " ( 13, 'Cañada de Calatrava'), " +
                    " ( 13, 'Caracuel de Calatrava'), " +
                    " ( 13, 'Carrión de Calatrava'), " +
                    " ( 13, 'Carrizosa'), " +
                    " ( 13, 'Castellar de Santiago'), " +
                    " ( 13, 'Chillón'), " +
                    " ( 13, 'Ciudad Real'), " +
                    " ( 13, 'Corral de Calatrava'), " +
                    " ( 13, 'Cortijos (Los)'), " +
                    " ( 13, 'Cózar'), " +
                    " ( 13, 'Daimiel'), " +
                    " ( 13, 'Fernán Caballero'), " +
                    " ( 13, 'Fontanarejo'), " +
                    " ( 13, 'Fuencaliente'), " +
                    " ( 13, 'Fuenllana'), " +
                    " ( 13, 'Fuente el Fresno'), " +
                    " ( 13, 'Granátula de Calatrava'), " +
                    " ( 13, 'Guadalmez'), " +
                    " ( 13, 'Herencia'); " );
                    
                    stmt.executeUpdate("INSERT INTO `zk_poblacion` (`provincia`, `poblacion`) VALUES " +
                    " ( 13, 'Hinojosas de Calatrava'), " +
                    " ( 13, 'Horcajo de los Montes'), " +
                    " ( 13, 'Labores (Las)'), " +
                    " ( 13, 'Llanos del Caudillo'), " +
                    " ( 13, 'Luciana'), " +
                    " ( 13, 'Malagón'), " +
                    " ( 13, 'Manzanares'), " +
                    " ( 13, 'Membrilla'), " +
                    " ( 13, 'Mestanza'), " +
                    " ( 13, 'Miguelturra'), " +
                    " ( 13, 'Montiel'), " +
                    " ( 13, 'Moral de Calatrava'), " +
                    " ( 13, 'Navalpino'), " +
                    " ( 13, 'Navas de Estena'), " +
                    " ( 13, 'Pedro Muñoz'), " +
                    " ( 13, 'Picón'), " +
                    " ( 13, 'Piedrabuena'), " +
                    " ( 13, 'Poblete'), " +
                    " ( 13, 'Porzuna'), " +
                    " ( 13, 'Pozuelo de Calatrava'), " +
                    " ( 13, 'Pozuelos de Calatrava (Los)'), " +
                    " ( 13, 'Puebla de Don Rodrigo'), " +
                    " ( 13, 'Puebla del Príncipe'), " +
                    " ( 13, 'Puerto Lápice'), " +
                    " ( 13, 'Puertollano'), " +
                    " ( 13, 'Retuerta del Bullaque'), " +
                    " ( 13, 'Robledo (El)'), " +
                    " ( 13, 'Ruidera'), " +
                    " ( 13, 'Saceruela'), " +
                    " ( 13, 'San Carlos del Valle'), " +
                    " ( 13, 'San Lorenzo de Calatrava'), " +
                    " ( 13, 'Santa Cruz de los Cáñamos'), " +
                    " ( 13, 'Santa Cruz de Mudela'), " +
                    " ( 13, 'Socuéllamos'), " +
                    " ( 13, 'Solana (La)'), " +
                    " ( 13, 'Solana del Pino'), " +
                    " ( 13, 'Terrinches'), " +
                    " ( 13, 'Tomelloso'), " +
                    " ( 13, 'Torralba de Calatrava'), " +
                    " ( 13, 'Torre de Juan Abad'), " +
                    " ( 13, 'Torrenueva'), " +
                    " ( 13, 'Valdemanco del Esteras'), " +
                    " ( 13, 'Valdepeñas'), " +
                    " ( 13, 'Valenzuela de Calatrava'), " +
                    " ( 13, 'Villahermosa'), " +
                    " ( 13, 'Villamanrique'), " +
                    " ( 13, 'Villamayor de Calatrava'), " +
                    " ( 13, 'Villanueva de la Fuente'), " +
                    " ( 13, 'Villanueva de los Infantes'), " +
                    " ( 13, 'Villanueva de San Carlos'), " +
                    " ( 13, 'Villar del Pozo'), " +
                    " ( 13, 'Villarrubia de los Ojos'), " +
                    " ( 13, 'Villarta de San Juan'), " +
                    " ( 13, 'Viso del Marqués'), " +
                    " ( 14, 'Adamuz'), " +
                    " ( 14, 'Aguilar de la Frontera'), " +
                    " ( 14, 'Alcaracejos'), " +
                    " ( 14, 'Almedinilla'), " +
                    " ( 14, 'Almodóvar del Río'), " +
                    " ( 14, 'Añora'), " +
                    " ( 14, 'Baena'), " +
                    " ( 14, 'Belalcázar'), " +
                    " ( 14, 'Belmez'), " +
                    " ( 14, 'Benamejí'), " +
                    " ( 14, 'Blázquez (Los)'), " +
                    " ( 14, 'Bujalance'), " +
                    " ( 14, 'Cabra'), " +
                    " ( 14, 'Cañete de las Torres'), " +
                    " ( 14, 'Carcabuey'), " +
                    " ( 14, 'Cardeña'), " +
                    " ( 14, 'Carlota (La)'), " +
                    " ( 14, 'Carpio (El)'), " +
                    " ( 14, 'Castro del Río'), " +
                    " ( 14, 'Conquista'), " +
                    " ( 14, 'Córdoba'), " +
                    " ( 14, 'Doña Mencía'), " +
                    " ( 14, 'Dos Torres'), " +
                    " ( 14, 'Encinas Reales'), " +
                    " ( 14, 'Espejo'), " +
                    " ( 14, 'Espiel'), " +
                    " ( 14, 'Fernán-Núñez'), " +
                    " ( 14, 'Fuente la Lancha'), " +
                    " ( 14, 'Fuente Obejuna'), " +
                    " ( 14, 'Fuente Palmera'), " +
                    " ( 14, 'Fuente-Tójar'), " +
                    " ( 14, 'Granjuela (La)'), " +
                    " ( 14, 'Guadalcázar'), " +
                    " ( 14, 'Guijo (El)'), " +
                    " ( 14, 'Hinojosa del Duque'), " +
                    " ( 14, 'Hornachuelos'), " +
                    " ( 14, 'Iznájar'), " +
                    " ( 14, 'Lucena'), " +
                    " ( 14, 'Luque'), " +
                    " ( 14, 'Montalbán de Córdoba'), " +
                    " ( 14, 'Montemayor'), " +
                    " ( 14, 'Montilla'), " +
                    " ( 14, 'Montoro'), " +
                    " ( 14, 'Monturque'), " +
                    " ( 14, 'Moriles'), " +
                    " ( 14, 'Nueva Carteya'), " +
                    " ( 14, 'Obejo'), " +
                    " ( 14, 'Palenciana'), " +
                    " ( 14, 'Palma del Río'), " +
                    " ( 14, 'Pedro Abad'), " +
                    " ( 14, 'Pedroche'), " +
                    " ( 14, 'Peñarroya-Pueblonuevo'), " +
                    " ( 14, 'Posadas'), " +
                    " ( 14, 'Pozoblanco'), " +
                    " ( 14, 'Priego de Córdoba'), " +
                    " ( 14, 'Puente Genil'), " +
                    " ( 14, 'Rambla (La)'), " +
                    " ( 14, 'Rute'), " +
                    " ( 14, 'San Sebastián de los Ballesteros'), " +
                    " ( 14, 'Santa Eufemia'), " +
                    " ( 14, 'Santaella'), " +
                    " ( 14, 'Torrecampo'), " +
                    " ( 14, 'Valenzuela'), " +
                    " ( 14, 'Valsequillo'), " +
                    " ( 14, 'Victoria (La)'), " +
                    " ( 14, 'Villa del Río'), " +
                    " ( 14, 'Villafranca de Córdoba'), " +
                    " ( 14, 'Villaharta'), " +
                    " ( 14, 'Villanueva de Córdoba'), " +
                    " ( 14, 'Villanueva del Duque'), " +
                    " ( 14, 'Villanueva del Rey'), " +
                    " ( 14, 'Villaralto'), " +
                    " ( 14, 'Villaviciosa de Córdoba'), " +
                    " ( 14, 'Viso (El)'), " +
                    " ( 14, 'Zuheros'), " +
                    " ( 15, 'Abegondo'), " +
                    " ( 15, 'Ames'), " +
                    " ( 15, 'Aranga'), " +
                    " ( 15, 'Ares'), " +
                    " ( 15, 'Arteixo'), " +
                    " ( 15, 'Arzúa'), " +
                    " ( 15, 'Baña (A)'), " +
                    " ( 15, 'Bergondo'), " +
                    " ( 15, 'Betanzos'), " +
                    " ( 15, 'Boimorto'), " +
                    " ( 15, 'Boiro'), " +
                    " ( 15, 'Boqueixón'), " +
                    " ( 15, 'Brión'), " +
                    " ( 15, 'Cabana de Bergantiños'), " +
                    " ( 15, 'Cabanas'), " +
                    " ( 15, 'Camariñas'), " +
                    " ( 15, 'Cambre'), " +
                    " ( 15, 'Capela (A)'), " +
                    " ( 15, 'Carballo'), " +
                    " ( 15, 'Cariño'), " +
                    " ( 15, 'Carnota'), " +
                    " ( 15, 'Carral'), " +
                    " ( 15, 'Cedeira'), " +
                    " ( 15, 'Cee'), " +
                    " ( 15, 'Cerceda'), " +
                    " ( 15, 'Cerdido'), " +
                    " ( 15, 'Cesuras'), " +
                    " ( 15, 'Coirós'), " +
                    " ( 15, 'Corcubión'), " +
                    " ( 15, 'Coristanco'), " +
                    " ( 15, 'Coruña (A)'), " +
                    " ( 15, 'Culleredo'), " +
                    " ( 15, 'Curtis'), " +
                    " ( 15, 'Dodro'), " +
                    " ( 15, 'Dumbría'), " +
                    " ( 15, 'Fene'), " +
                    " ( 15, 'Ferrol'), " +
                    " ( 15, 'Fisterra'), " +
                    " ( 15, 'Frades'), " +
                    " ( 15, 'Irixoa'), " +
                    " ( 15, 'Laracha (A)'), " +
                    " ( 15, 'Laxe'), " +
                    " ( 15, 'Lousame'), " +
                    " ( 15, 'Malpica de Bergantiños'), " +
                    " ( 15, 'Mañón'), " +
                    " ( 15, 'Mazaricos'), " +
                    " ( 15, 'Melide'), " +
                    " ( 15, 'Mesía'), " +
                    " ( 15, 'Miño'), " +
                    " ( 15, 'Moeche'), " +
                    " ( 15, 'Monfero'), " +
                    " ( 15, 'Mugardos'), " +
                    " ( 15, 'Muros'), " +
                    " ( 15, 'Muxía'), " +
                    " ( 15, 'Narón'), " +
                    " ( 15, 'Neda'), " +
                    " ( 15, 'Negreira'), " +
                    " ( 15, 'Noia'), " +
                    " ( 15, 'Oleiros'), " +
                    " ( 15, 'Ordes'), " +
                    " ( 15, 'Oroso'), " +
                    " ( 15, 'Ortigueira'), " +
                    " ( 15, 'Outes'), " +
                    " ( 15, 'Oza dos Ríos'), " +
                    " ( 15, 'Paderne'), " +
                    " ( 15, 'Padrón'), " +
                    " ( 15, 'Pino (O)'), " +
                    " ( 15, 'Pobra do Caramiñal (A)'), " +
                    " ( 15, 'Ponteceso'), " +
                    " ( 15, 'Pontedeume'), " +
                    " ( 15, 'Pontes de García Rodríguez (As)'), " +
                    " ( 15, 'Porto do Son'), " +
                    " ( 15, 'Rianxo'), " +
                    " ( 15, 'Ribeira'), " +
                    " ( 15, 'Rois'), " +
                    " ( 15, 'Sada'), " +
                    " ( 15, 'San Sadurniño'), " +
                    " ( 15, 'Santa Comba'), " +
                    " ( 15, 'Santiago de Compostela'), " +
                    " ( 15, 'Santiso'), " +
                    " ( 15, 'Sobrado'), " +
                    " ( 15, 'Somozas (As)'), " +
                    " ( 15, 'Teo'), " +
                    " ( 15, 'Toques'), " +
                    " ( 15, 'Tordoia'), " +
                    " ( 15, 'Touro'), " +
                    " ( 15, 'Trazo'), " +
                    " ( 15, 'Val do Dubra'), " +
                    " ( 15, 'Valdoviño'), " +
                    " ( 15, 'Vedra'), " +
                    " ( 15, 'Vilarmaior'), " +
                    " ( 15, 'Vilasantar'), " +
                    " ( 15, 'Vimianzo'), " +
                    " ( 15, 'Zas'), " +
                    " ( 16, 'Abia de la Obispalía'), " +
                    " ( 16, 'Acebrón (El)'), " +
                    " ( 16, 'Alarcón'), " +
                    " ( 16, 'Albaladejo del Cuende'), " +
                    " ( 16, 'Albalate de las Nogueras'), " +
                    " ( 16, 'Albendea'), " +
                    " ( 16, 'Alberca de Záncara (La)'), " +
                    " ( 16, 'Alcalá de la Vega'), " +
                    " ( 16, 'Alcantud'), " +
                    " ( 16, 'Alcázar del Rey'), " +
                    " ( 16, 'Alcohujate'), " +
                    " ( 16, 'Alconchel de la Estrella'), " +
                    " ( 16, 'Algarra'), " +
                    " ( 16, 'Aliaguilla'), " +
                    " ( 16, 'Almarcha (La)'), " +
                    " ( 16, 'Almendros'), " +
                    " ( 16, 'Almodóvar del Pinar'), " +
                    " ( 16, 'Almonacid del Marquesado'), " +
                    " ( 16, 'Altarejos'), " +
                    " ( 16, 'Arandilla del Arroyo'), " +
                    " ( 16, 'Arcas del Villar'), " +
                    " ( 16, 'Arcos de la Sierra'), " +
                    " ( 16, 'Arguisuelas'), " +
                    " ( 16, 'Arrancacepas'), " +
                    " ( 16, 'Atalaya del Cañavate'), " +
                    " ( 16, 'Barajas de Melo'), " +
                    " ( 16, 'Barchín del Hoyo'), " +
                    " ( 16, 'Bascuñana de San Pedro'), " +
                    " ( 16, 'Beamud'), " +
                    " ( 16, 'Belinchón'), " +
                    " ( 16, 'Belmonte'), " +
                    " ( 16, 'Belmontejo'), " +
                    " ( 16, 'Beteta'), " +
                    " ( 16, 'Boniches'), " +
                    " ( 16, 'Buciegas'), " +
                    " ( 16, 'Buenache de Alarcón'), " +
                    " ( 16, 'Buenache de la Sierra'), " +
                    " ( 16, 'Buendía'), " +
                    " ( 16, 'Campillo de Altobuey'), " +
                    " ( 16, 'Campillos-Paravientos'), " +
                    " ( 16, 'Campillos-Sierra'), " +
                    " ( 16, 'Campos del Paraíso'), " +
                    " ( 16, 'Canalejas del Arroyo'), " +
                    " ( 16, 'Cañada del Hoyo'), " +
                    " ( 16, 'Cañada Juncosa'), " +
                    " ( 16, 'Cañamares'), " +
                    " ( 16, 'Cañavate (El)'), " +
                    " ( 16, 'Cañaveras'), " +
                    " ( 16, 'Cañaveruelas'), " +
                    " ( 16, 'Cañete'), " +
                    " ( 16, 'Cañizares'), " +
                    " ( 16, 'Carboneras de Guadazaón'), " +
                    " ( 16, 'Cardenete'), " +
                    " ( 16, 'Carrascosa'), " +
                    " ( 16, 'Carrascosa de Haro'), " +
                    " ( 16, 'Casas de Benítez'), " +
                    " ( 16, 'Casas de Fernando Alonso'), " +
                    " ( 16, 'Casas de Garcimolina'), " +
                    " ( 16, 'Casas de Guijarro'), " +
                    " ( 16, 'Casas de Haro'), " +
                    " ( 16, 'Casas de los Pinos'), " +
                    " ( 16, 'Casasimarro'), " +
                    " ( 16, 'Castejón'), " +
                    " ( 16, 'Castillejo de Iniesta'), " +
                    " ( 16, 'Castillejo-Sierra'), " +
                    " ( 16, 'Castillo de Garcimuñoz'), " +
                    " ( 16, 'Castillo-Albaráñez'), " +
                    " ( 16, 'Cervera del Llano'), " +
                    " ( 16, 'Chillarón de Cuenca'), " +
                    " ( 16, 'Chumillas'), " +
                    " ( 16, 'Cierva (La)'), " +
                    " ( 16, 'Cuenca'), " +
                    " ( 16, 'Cueva del Hierro'), " +
                    " ( 16, 'Enguídanos'), " +
                    " ( 16, 'Fresneda de Altarejos'), " +
                    " ( 16, 'Fresneda de la Sierra'), " +
                    " ( 16, 'Frontera (La)'), " +
                    " ( 16, 'Fuente de Pedro Naharro'), " +
                    " ( 16, 'Fuentelespino de Haro'), " +
                    " ( 16, 'Fuentelespino de Moya'), " +
                    " ( 16, 'Fuentenava de Jábaga'), " +
                    " ( 16, 'Fuentes'), " +
                    " ( 16, 'Fuertescusa'), " +
                    " ( 16, 'Gabaldón'), " +
                    " ( 16, 'Garaballa'), " +
                    " ( 16, 'Gascueña'), " +
                    " ( 16, 'Graja de Campalbo'), " +
                    " ( 16, 'Graja de Iniesta'), " +
                    " ( 16, 'Henarejos'), " +
                    " ( 16, 'Herrumblar (El)'), " +
                    " ( 16, 'Hinojosa (La)'), " +
                    " ( 16, 'Hinojosos (Los)'), " +
                    " ( 16, 'Hito (El)'), " +
                    " ( 16, 'Honrubia'), " +
                    " ( 16, 'Hontanaya'), " +
                    " ( 16, 'Hontecillas'), " +
                    " ( 16, 'Horcajo de Santiago'), " +
                    " ( 16, 'Huélamo'), " +
                    " ( 16, 'Huelves'), " +
                    " ( 16, 'Huérguina'), " +
                    " ( 16, 'Huerta de la Obispalía'), " +
                    " ( 16, 'Huerta del Marquesado'), " +
                    " ( 16, 'Huete'), " +
                    " ( 16, 'Iniesta'), " +
                    " ( 16, 'Laguna del Marquesado'), " +
                    " ( 16, 'Lagunaseca'), " +
                    " ( 16, 'Landete'), " +
                    " ( 16, 'Ledaña'), " +
                    " ( 16, 'Leganiel'), " +
                    " ( 16, 'Majadas (Las)'), " +
                    " ( 16, 'Mariana'), " +
                    " ( 16, 'Masegosa'), " +
                    " ( 16, 'Mesas (Las)'), " +
                    " ( 16, 'Minglanilla'), " +
                    " ( 16, 'Mira'), " +
                    " ( 16, 'Monreal del Llano'), " +
                    " ( 16, 'Montalbanejo'), " +
                    " ( 16, 'Montalbo'), " +
                    " ( 16, 'Monteagudo de las Salinas'), " +
                    " ( 16, 'Mota de Altarejos'), " +
                    " ( 16, 'Mota del Cuervo'), " +
                    " ( 16, 'Motilla del Palancar'), " +
                    " ( 16, 'Moya'), " +
                    " ( 16, 'Narboneta'), " +
                    " ( 16, 'Olivares de Júcar'), " +
                    " ( 16, 'Olmeda de la Cuesta'), " +
                    " ( 16, 'Olmeda del Rey'), " +
                    " ( 16, 'Olmedilla de Alarcón'), " +
                    " ( 16, 'Olmedilla de Eliz'), " +
                    " ( 16, 'Osa de la Vega'), " +
                    " ( 16, 'Pajarón'), " +
                    " ( 16, 'Pajaroncillo'), " +
                    " ( 16, 'Palomares del Campo'), " +
                    " ( 16, 'Palomera'), " +
                    " ( 16, 'Paracuellos'), " +
                    " ( 16, 'Paredes'), " +
                    " ( 16, 'Parra de las Vegas (La)'), " +
                    " ( 16, 'Pedernoso (El)'), " +
                    " ( 16, 'Pedroñeras (Las)'), " +
                    " ( 16, 'Peral (El)'), " +
                    " ( 16, 'Peraleja (La)'), " +
                    " ( 16, 'Pesquera (La)'), " +
                    " ( 16, 'Picazo (El)'), " +
                    " ( 16, 'Pinarejo'), " +
                    " ( 16, 'Pineda de Gigüela'), " +
                    " ( 16, 'Piqueras del Castillo'), " +
                    " ( 16, 'Portalrubio de Guadamejud'), " +
                    " ( 16, 'Portilla'), " +
                    " ( 16, 'Poyatos'), " +
                    " ( 16, 'Pozoamargo'), " +
                    " ( 16, 'Pozorrubielos de la Mancha'), " +
                    " ( 16, 'Pozorrubio'), " +
                    " ( 16, 'Pozuelo (El)'), " +
                    " ( 16, 'Priego'), " +
                    " ( 16, 'Provencio (El)'), " +
                    " ( 16, 'Puebla de Almenara'), " +
                    " ( 16, 'Puebla de Don Francisco'), " +
                    " ( 16, 'Puebla del Salvador'), " +
                    " ( 16, 'Quintanar del Rey'), " +
                    " ( 16, 'Rada de Haro'), " +
                    " ( 16, 'Reíllo'), " +
                    " ( 16, 'Rozalén del Monte'), " +
                    " ( 16, 'Saceda-Trasierra'), " +
                    " ( 16, 'Saelices'), " +
                    " ( 16, 'Salinas del Manzano'), " +
                    " ( 16, 'Salmeroncillos'), " +
                    " ( 16, 'Salvacañete'), " +
                    " ( 16, 'San Clemente'), " +
                    " ( 16, 'San Lorenzo de la Parrilla'), " +
                    " ( 16, 'San Martín de Boniches'), " +
                    " ( 16, 'San Pedro Palmiches'), " +
                    " ( 16, 'Santa Cruz de Moya'), " +
                    " ( 16, 'Santa María de los Llanos'), " +
                    " ( 16, 'Santa María del Campo Rus'), " +
                    " ( 16, 'Santa María del Val'), " +
                    " ( 16, 'Sisante'), " +
                    " ( 16, 'Solera de Gabaldón'), " +
                    " ( 16, 'Sotorribas'), " +
                    " ( 16, 'Talayuelas'), " +
                    " ( 16, 'Tarancón'), " +
                    " ( 16, 'Tébar'), " +
                    " ( 16, 'Tejadillos'), " +
                    " ( 16, 'Tinajas'), " +
                    " ( 16, 'Torralba'), " +
                    " ( 16, 'Torrejoncillo del Rey'), " +
                    " ( 16, 'Torrubia del Campo'), " +
                    " ( 16, 'Torrubia del Castillo'), " +
                    " ( 16, 'Tragacete'), " +
                    " ( 16, 'Tresjuncos'), " +
                    " ( 16, 'Tribaldos'), " +
                    " ( 16, 'Uclés'), " +
                    " ( 16, 'Uña'), " +
                    " ( 16, 'Valdecolmenas (Los)'), " +
                    " ( 16, 'Valdemeca'), " +
                    " ( 16, 'Valdemorillo de la Sierra'), " +
                    " ( 16, 'Valdemoro-Sierra'), " +
                    " ( 16, 'Valdeolivas'), " +
                    " ( 16, 'Valdetórtola'), " +
                    " ( 16, 'Valeras (Las)'), " +
                    " ( 16, 'Valhermoso de la Fuente'), " +
                    " ( 16, 'Valsalobre'), " +
                    " ( 16, 'Valverde de Júcar'), " +
                    " ( 16, 'Valverdejo'), " +
                    " ( 16, 'Vara de Rey'), " +
                    " ( 16, 'Vega del Codorno'), " +
                    " ( 16, 'Vellisca'), " +
                    " ( 16, 'Villaconejos de Trabaque'), " +
                    " ( 16, 'Villaescusa de Haro'), " +
                    " ( 16, 'Villagarcía del Llano'), " +
                    " ( 16, 'Villalba de la Sierra'), " +
                    " ( 16, 'Villalba del Rey'), " +
                    " ( 16, 'Villalgordo del Marquesado'), " +
                    " ( 16, 'Villalpardo'), " +
                    " ( 16, 'Villamayor de Santiago'), " +
                    " ( 16, 'Villanueva de Guadamejud'), " +
                    " ( 16, 'Villanueva de la Jara'), " +
                    " ( 16, 'Villar de Cañas'), " +
                    " ( 16, 'Villar de Domingo García'), " +
                    " ( 16, 'Villar de la Encina'), " +
                    " ( 16, 'Villar de Olalla'), " +
                    " ( 16, 'Villar del Humo'), " +
                    " ( 16, 'Villar del Infantado'), " +
                    " ( 16, 'Villar y Velasco'), " +
                    " ( 16, 'Villarejo de Fuentes'), " +
                    " ( 16, 'Villarejo de la Peñuela'), " +
                    " ( 16, 'Villarejo-Periesteban'), " +
                    " ( 16, 'Villares del Saz'), " +
                    " ( 16, 'Villarrubio'), " +
                    " ( 16, 'Villarta'), " +
                    " ( 16, 'Villas de la Ventosa'), " +
                    " ( 16, 'Villaverde y Pasaconsol'), " +
                    " ( 16, 'Víllora'), " +
                    " ( 16, 'Vindel'), " +
                    " ( 16, 'Yémeda'), " +
                    " ( 16, 'Zafra de Záncara'), " +
                    " ( 16, 'Zafrilla'), " +
                    " ( 16, 'Zarza de Tajo'), " +
                    " ( 16, 'Zarzuela'), " +
                    " ( 17, 'Agullana'), " +
                    " ( 17, 'Aiguaviva'), " +
                    " ( 17, 'Albanyà'), " +
                    " ( 17, 'Albons'), " +
                    " ( 17, 'Alp'), " +
                    " ( 17, 'Amer'), " +
                    " ( 17, 'Anglès'), " +
                    " ( 17, 'Arbúcies'), " +
                    " ( 17, 'Argelaguer'), " +
                    " ( 17, 'Armentera (L'')'), " +
                    " ( 17, 'Avinyonet de Puigventós'), " +
                    " ( 17, 'Banyoles'), " +
                    " ( 17, 'Bàscara'), " +
                    " ( 17, 'Begur'), " +
                    " ( 17, 'Bellcaire d''Empordà'), " +
                    " ( 17, 'Besalú'), " +
                    " ( 17, 'Bescanó'), " +
                    " ( 17, 'Beuda'), " +
                    " ( 17, 'Bisbal d''Empordà (La)'), " +
                    " ( 17, 'Biure'), " +
                    " ( 17, 'Blanes'), " +
                    " ( 17, 'Boadella i les Escaules'), " +
                    " ( 17, 'Bolvir'), " +
                    " ( 17, 'Bordils'), " +
                    " ( 17, 'Borrassà'), " +
                    " ( 17, 'Breda'), " +
                    " ( 17, 'Brunyola'), " +
                    " ( 17, 'Cabanelles'), " +
                    " ( 17, 'Cabanes (Gerona)'), " +
                    " ( 17, 'Cadaqués'), " +
                    " ( 17, 'Caldes de Malavella'), " +
                    " ( 17, 'Calonge'), " +
                    " ( 17, 'Camós'), " +
                    " ( 17, 'Campdevànol'), " +
                    " ( 17, 'Campelles'), " +
                    " ( 17, 'Campllong'), " +
                    " ( 17, 'Camprodon'), " +
                    " ( 17, 'Canet d''Adri'), " +
                    " ( 17, 'Cantallops'), " +
                    " ( 17, 'Capmany'), " +
                    " ( 17, 'Cassà de la Selva'), " +
                    " ( 17, 'Castellfollit de la Roca'), " +
                    " ( 17, 'Castelló d''Empúries'), " +
                    " ( 17, 'Castell-Platja d''Aro'), " +
                    " ( 17, 'Cellera de Ter (La)'), " +
                    " ( 17, 'Celrà'), " +
                    " ( 17, 'Cervià de Ter'), " +
                    " ( 17, 'Cistella'), " +
                    " ( 17, 'Colera'), " +
                    " ( 17, 'Colomers'), " +
                    " ( 17, 'Corçà'), " +
                    " ( 17, 'Cornellà del Terri'), " +
                    " ( 17, 'Crespià'), " +
                    " ( 17, 'Cruïlles, Monells i Sant Sadurní de l''Heura'), " +
                    " ( 17, 'Darnius'), " +
                    " ( 17, 'Das'), " +
                    " ( 17, 'Escala (L'')'), " +
                    " ( 17, 'Espinelves'), " +
                    " ( 17, 'Espolla'), " +
                    " ( 17, 'Esponellà'), " +
                    " ( 17, 'Far d''Empordà (El)'), " +
                    " ( 17, 'Figueres'), " +
                    " ( 17, 'Flaçà'), " +
                    " ( 17, 'Foixà'), " +
                    " ( 17, 'Fontanals de Cerdanya'), " +
                    " ( 17, 'Fontanilles'), " +
                    " ( 17, 'Fontcoberta'), " +
                    " ( 17, 'Forallac'), " +
                    " ( 17, 'Fornells de la Selva'), " +
                    " ( 17, 'Fortià'), " +
                    " ( 17, 'Garrigàs'), " +
                    " ( 17, 'Garrigoles'), " +
                    " ( 17, 'Garriguella'), " +
                    " ( 17, 'Ger'), " +
                    " ( 17, 'Girona'), " +
                    " ( 17, 'Gombrèn'), " +
                    " ( 17, 'Gualta'), " +
                    " ( 17, 'Guils de Cerdanya'), " +
                    " ( 17, 'Hostalric'), " +
                    " ( 17, 'Isòvol'), " +
                    " ( 17, 'Jafre'), " +
                    " ( 17, 'Jonquera (La)'), " +
                    " ( 17, 'Juià'), " +
                    " ( 17, 'Lladó'), " +
                    " ( 17, 'Llagostera'), " +
                    " ( 17, 'Llambilles'), " +
                    " ( 17, 'Llanars'), " +
                    " ( 17, 'Llançà'), " +
                    " ( 17, 'Llers'), " +
                    " ( 17, 'Llívia'), " +
                    " ( 17, 'Lloret de Mar'), " +
                    " ( 17, 'Llosses (Les)'), " +
                    " ( 17, 'Maçanet de Cabrenys'), " +
                    " ( 17, 'Maçanet de la Selva'), " +
                    " ( 17, 'Madremanya'), " +
                    " ( 17, 'Maià de Montcal'), " +
                    " ( 17, 'Masarac'), " +
                    " ( 17, 'Massanes'), " +
                    " ( 17, 'Meranges'), " +
                    " ( 17, 'Mieres'), " +
                    " ( 17, 'Mollet de Peralada'), " +
                    " ( 17, 'Molló'), " +
                    " ( 17, 'Montagut i Oix'), " +
                    " ( 17, 'Mont-ras'), " +
                    " ( 17, 'Navata'), " +
                    " ( 17, 'Ogassa'), " +
                    " ( 17, 'Olot'), " +
                    " ( 17, 'Ordis'), " +
                    " ( 17, 'Osor'), " +
                    " ( 17, 'Palafrugell'), " +
                    " ( 17, 'Palamós'), " +
                    " ( 17, 'Palau de Santa Eulàlia'), " +
                    " ( 17, 'Palau-sator'), " +
                    " ( 17, 'Palau-saverdera'), " +
                    " ( 17, 'Palol de Revardit'), " +
                    " ( 17, 'Pals'), " +
                    " ( 17, 'Pardines'), " +
                    " ( 17, 'Parlavà'), " +
                    " ( 17, 'Pau'), " +
                    " ( 17, 'Pedret i Marzà'), " +
                    " ( 17, 'Pera (La)'), " +
                    " ( 17, 'Peralada'), " +
                    " ( 17, 'Planes d''Hostoles (Les)'), " +
                    " ( 17, 'Planoles'), " +
                    " ( 17, 'Pont de Molins'), " +
                    " ( 17, 'Pontós'), " +
                    " ( 17, 'Porqueres'), " +
                    " ( 17, 'Port de la Selva (El)'), " +
                    " ( 17, 'Portbou'), " +
                    " ( 17, 'Preses (Les)'), " +
                    " ( 17, 'Puigcerdà'), " +
                    " ( 17, 'Quart'), " +
                    " ( 17, 'Queralbs'), " +
                    " ( 17, 'Rabós'), " +
                    " ( 17, 'Regencós'), " +
                    " ( 17, 'Ribes de Freser'), " +
                    " ( 17, 'Riells i Viabrea'), " +
                    " ( 17, 'Ripoll'), " +
                    " ( 17, 'Riudarenes'), " +
                    " ( 17, 'Riudaura'), " +
                    " ( 17, 'Riudellots de la Selva'), " +
                    " ( 17, 'Riumors'), " +
                    " ( 17, 'Roses'), " +
                    " ( 17, 'Rupià'), " +
                    " ( 17, 'Sales de Llierca'), " +
                    " ( 17, 'Salt'), " +
                    " ( 17, 'Sant Andreu Salou'), " +
                    " ( 17, 'Sant Aniol de Finestres'), " +
                    " ( 17, 'Sant Climent Sescebes'), " +
                    " ( 17, 'Sant Feliu de Buixalleu'), " +
                    " ( 17, 'Sant Feliu de Guíxols'), " +
                    " ( 17, 'Sant Feliu de Pallerols'), " +
                    " ( 17, 'Sant Ferriol'), " +
                    " ( 17, 'Sant Gregori'), " +
                    " ( 17, 'Sant Hilari Sacalm'), " +
                    " ( 17, 'Sant Jaume de Llierca'), " +
                    " ( 17, 'Sant Joan de les Abadesses'), " +
                    " ( 17, 'Sant Joan de Mollet'), " +
                    " ( 17, 'Sant Joan les Fonts'), " +
                    " ( 17, 'Sant Jordi Desvalls'), " +
                    " ( 17, 'Sant Julià de Ramis'), " +
                    " ( 17, 'Sant Julià del Llor i Bonmatí'), " +
                    " ( 17, 'Sant Llorenç de la Muga'), " +
                    " ( 17, 'Sant Martí de Llémena'), " +
                    " ( 17, 'Sant Martí Vell'), " +
                    " ( 17, 'Sant Miquel de Campmajor'), " +
                    " ( 17, 'Sant Miquel de Fluvià'), " +
                    " ( 17, 'Sant Mori'), " +
                    " ( 17, 'Sant Pau de Segúries'), " +
                    " ( 17, 'Sant Pere Pescador'), " +
                    " ( 17, 'Santa Coloma de Farners'), " +
                    " ( 17, 'Santa Cristina d''Aro'), " +
                    " ( 17, 'Santa Llogaia d''Àlguema'), " +
                    " ( 17, 'Santa Pau'), " +
                    " ( 17, 'Sarrià de Ter'), " +
                    " ( 17, 'Saus, Camallera i Llampaies'), " +
                    " ( 17, 'Selva de Mar (La)'), " +
                    " ( 17, 'Serinyà'), " +
                    " ( 17, 'Serra de Daró'), " +
                    " ( 17, 'Setcases'), " +
                    " ( 17, 'Sils'), " +
                    " ( 17, 'Siurana'), " +
                    " ( 17, 'Susqueda'), " +
                    " ( 17, 'Tallada d''Empordà (La)'), " +
                    " ( 17, 'Terrades'), " +
                    " ( 17, 'Torrent'), " +
                    " ( 17, 'Torroella de Fluvià'), " +
                    " ( 17, 'Torroella de Montgrí'), " +
                    " ( 17, 'Tortellà'), " +
                    " ( 17, 'Toses'), " +
                    " ( 17, 'Tossa de Mar'), " +
                    " ( 17, 'Ullà'), " +
                    " ( 17, 'Ullastret'), " +
                    " ( 17, 'Ultramort'), " +
                    " ( 17, 'Urús'), " +
                    " ( 17, 'Vajol (La)'), " +
                    " ( 17, 'Vall de Bianya (La)'), " +
                    " ( 17, 'Vall d''en Bas (La)'), " +
                    " ( 17, 'Vallfogona de Ripollès'), " +
                    " ( 17, 'Vall-llobrega'), " +
                    " ( 17, 'Ventalló'), " +
                    " ( 17, 'Verges'), " +
                    " ( 17, 'Vidrà'), " +
                    " ( 17, 'Vidreres'), " +
                    " ( 17, 'Vilabertran'), " +
                    " ( 17, 'Vilablareix'), " +
                    " ( 17, 'Viladamat'), " +
                    " ( 17, 'Viladasens'), " +
                    " ( 17, 'Vilademuls'), " +
                    " ( 17, 'Viladrau'), " +
                    " ( 17, 'Vilafant'), " +
                    " ( 17, 'Vilajuïga'), " +
                    " ( 17, 'Vilallonga de Ter'), " +
                    " ( 17, 'Vilamacolum'), " +
                    " ( 17, 'Vilamalla'), " +
                    " ( 17, 'Vilamaniscle'), " +
                    " ( 17, 'Vilanant'), " +
                    " ( 17, 'Vila-sacra'), " +
                    " ( 17, 'Vilaür'), " +
                    " ( 17, 'Vilobí d''Onyar'), " +
                    " ( 17, 'Vilopriu'), " +
                    " ( 18, 'Agrón'), " +
                    " ( 18, 'Alamedilla'), " +
                    " ( 18, 'Albolote'), " +
                    " ( 18, 'Albondón'), " +
                    " ( 18, 'Albuñán'), " +
                    " ( 18, 'Albuñol'), " +
                    " ( 18, 'Albuñuelas'), " +
                    " ( 18, 'Aldeire'), " +
                    " ( 18, 'Alfacar'), " +
                    " ( 18, 'Algarinejo'), " +
                    " ( 18, 'Alhama de Granada'), " +
                    " ( 18, 'Alhendín'), " +
                    " ( 18, 'Alicún de Ortega'), " +
                    " ( 18, 'Almegíjar'), " +
                    " ( 18, 'Almuñécar'), " +
                    " ( 18, 'Alpujarra de la Sierra'), " +
                    " ( 18, 'Alquife'), " +
                    " ( 18, 'Arenas del Rey'), " +
                    " ( 18, 'Armilla'), " +
                    " ( 18, 'Atarfe'), " +
                    " ( 18, 'Baza'), " +
                    " ( 18, 'Beas de Granada'), " +
                    " ( 18, 'Beas de Guadix'), " +
                    " ( 18, 'Benalúa'), " +
                    " ( 18, 'Benalúa de las Villas'), " +
                    " ( 18, 'Benamaurel'), " +
                    " ( 18, 'Bérchules'), " +
                    " ( 18, 'Bubión'), " +
                    " ( 18, 'Busquístar'), " +
                    " ( 18, 'Cacín'), " +
                    " ( 18, 'Cádiar'), " +
                    " ( 18, 'Cájar'), " +
                    " ( 18, 'Calahorra (La)'), " +
                    " ( 18, 'Calicasas'), " +
                    " ( 18, 'Campotéjar'), " +
                    " ( 18, 'Caniles'), " +
                    " ( 18, 'Cáñar'), " +
                    " ( 18, 'Capileira'), " +
                    " ( 18, 'Carataunas'), " +
                    " ( 18, 'Cástaras'), " +
                    " ( 18, 'Castilléjar'), " +
                    " ( 18, 'Castril'), " +
                    " ( 18, 'Cenes de la Vega'), " +
                    " ( 18, 'Chauchina'), " +
                    " ( 18, 'Chimeneas'), " +
                    " ( 18, 'Churriana de la Vega'), " +
                    " ( 18, 'Cijuela'), " +
                    " ( 18, 'Cogollos de Guadix'), " +
                    " ( 18, 'Cogollos de la Vega'), " +
                    " ( 18, 'Colomera'), " +
                    " ( 18, 'Cortes de Baza'), " +
                    " ( 18, 'Cortes y Graena'), " +
                    " ( 18, 'Cuevas del Campo'), " +
                    " ( 18, 'Cúllar'), " +
                    " ( 18, 'Cúllar Vega'), " +
                    " ( 18, 'Darro'), " +
                    " ( 18, 'Dehesas de Guadix'), " +
                    " ( 18, 'Deifontes'), " +
                    " ( 18, 'Diezma'), " +
                    " ( 18, 'Dílar'), " +
                    " ( 18, 'Dólar'), " +
                    " ( 18, 'Dúdar'), " +
                    " ( 18, 'Dúrcal'), " +
                    " ( 18, 'Escúzar'), " +
                    " ( 18, 'Ferreira'), " +
                    " ( 18, 'Fonelas'), " +
                    " ( 18, 'Freila'), " +
                    " ( 18, 'Fuente Vaqueros'), " +
                    " ( 18, 'Gabias (Las)'), " +
                    " ( 18, 'Galera'), " +
                    " ( 18, 'Gobernador'), " +
                    " ( 18, 'Gójar'), " +
                    " ( 18, 'Gor'), " +
                    " ( 18, 'Gorafe'), " +
                    " ( 18, 'Granada'), " +
                    " ( 18, 'Guadahortuna'), " +
                    " ( 18, 'Guadix'), " +
                    " ( 18, 'Guajares (Los)'), " +
                    " ( 18, 'Gualchos'), " +
                    " ( 18, 'Güejar Sierra'), " +
                    " ( 18, 'Güevéjar'), " +
                    " ( 18, 'Huélago'), " +
                    " ( 18, 'Huéneja'), " +
                    " ( 18, 'Huéscar'), " +
                    " ( 18, 'Huétor de Santillán'), " +
                    " ( 18, 'Huétor Tájar'), " +
                    " ( 18, 'Huétor Vega'), " +
                    " ( 18, 'Illora'), " +
                    " ( 18, 'Itrabo'), " +
                    " ( 18, 'Iznalloz'), " +
                    " ( 18, 'Jayena'), " +
                    " ( 18, 'Jerez del Marquesado'), " +
                    " ( 18, 'Jete'), " +
                    " ( 18, 'Jun'), " +
                    " ( 18, 'Juviles'), " +
                    " ( 18, 'Láchar'), " +
                    " ( 18, 'Lanjarón'), " +
                    " ( 18, 'Lanteira'), " +
                    " ( 18, 'Lecrín'), " +
                    " ( 18, 'Lentegí'), " +
                    " ( 18, 'Lobras'), " +
                    " ( 18, 'Loja'), " +
                    " ( 18, 'Lugros'), " +
                    " ( 18, 'Lújar'), " +
                    " ( 18, 'Malahá (La)'), " +
                    " ( 18, 'Maracena'), " +
                    " ( 18, 'Marchal'), " +
                    " ( 18, 'Moclín'), " +
                    " ( 18, 'Molvízar'), " +
                    " ( 18, 'Monachil'), " +
                    " ( 18, 'Montefrío'), " +
                    " ( 18, 'Montejícar'), " +
                    " ( 18, 'Montillana'), " +
                    " ( 18, 'Moraleda de Zafayona'), " +
                    " ( 18, 'Morelábor'), " +
                    " ( 18, 'Motril'), " +
                    " ( 18, 'Murtas'), " +
                    " ( 18, 'Nevada'), " +
                    " ( 18, 'Nigüelas'), " +
                    " ( 18, 'Nívar'), " +
                    " ( 18, 'Ogíjares'), " +
                    " ( 18, 'Orce'), " +
                    " ( 18, 'Órgiva'), " +
                    " ( 18, 'Otívar'), " +
                    " ( 18, 'Otura'), " +
                    " ( 18, 'Padul'), " +
                    " ( 18, 'Pampaneira'), " +
                    " ( 18, 'Pedro Martínez'), " +
                    " ( 18, 'Peligros'), " +
                    " ( 18, 'Peza (La)'), " +
                    " ( 18, 'Pinar (El)'), " +
                    " ( 18, 'Pinos Genil'), " +
                    " ( 18, 'Pinos Puente'), " +
                    " ( 18, 'Píñar'), " +
                    " ( 18, 'Polícar'), " +
                    " ( 18, 'Polopos'), " +
                    " ( 18, 'Pórtugos'), " +
                    " ( 18, 'Puebla de Don Fadrique'), " +
                    " ( 18, 'Pulianas'), " +
                    " ( 18, 'Purullena'), " +
                    " ( 18, 'Quéntar'), " +
                    " ( 18, 'Rubite'), " +
                    " ( 18, 'Salar'), " +
                    " ( 18, 'Salobreña'), " +
                    " ( 18, 'Santa Cruz del Comercio'), " +
                    " ( 18, 'Santa Fe'), " +
                    " ( 18, 'Soportújar'), " +
                    " ( 18, 'Sorvilán'), " +
                    " ( 18, 'Taha (La)'), " +
                    " ( 18, 'Torre-Cardela'), " +
                    " ( 18, 'Torvizcón'), " +
                    " ( 18, 'Trevélez'), " +
                    " ( 18, 'Turón'), " +
                    " ( 18, 'Ugíjar'), " +
                    " ( 18, 'Valle (El)'), " +
                    " ( 18, 'Valle del Zalabí'), " +
                    " ( 18, 'Válor'), " +
                    " ( 18, 'Vegas del Genil'), " +
                    " ( 18, 'Vélez de Benaudalla'), " +
                    " ( 18, 'Ventas de Huelma'), " +
                    " ( 18, 'Villamena'), " +
                    " ( 18, 'Villanueva de las Torres'), " +
                    " ( 18, 'Villanueva Mesía'), " +
                    " ( 18, 'Víznar'), " +
                    " ( 18, 'Zafarraya'), " +
                    " ( 18, 'Zagra'), " +
                    " ( 18, 'Zubia (La)'), " +
                    " ( 18, 'Zújar'), " +
                    " ( 19, 'Abánades'), " +
                    " ( 19, 'Ablanque'), " +
                    " ( 19, 'Adobes'), " +
                    " ( 19, 'Alaminos'), " +
                    " ( 19, 'Alarilla'), " +
                    " ( 19, 'Albalate de Zorita'), " +
                    " ( 19, 'Albares'), " +
                    " ( 19, 'Albendiego'), " +
                    " ( 19, 'Alcocer'), " +
                    " ( 19, 'Alcolea de las Peñas'), " +
                    " ( 19, 'Alcolea del Pinar'), " +
                    " ( 19, 'Alcoroches'), " +
                    " ( 19, 'Aldeanueva de Guadalajara'), " +
                    " ( 19, 'Algar de Mesa'), " +
                    " ( 19, 'Algora'), " +
                    " ( 19, 'Alhóndiga'), " +
                    " ( 19, 'Alique'), " +
                    " ( 19, 'Almadrones'), " +
                    " ( 19, 'Almoguera'), " +
                    " ( 19, 'Almonacid de Zorita'), " +
                    " ( 19, 'Alocén'), " +
                    " ( 19, 'Alovera'), " +
                    " ( 19, 'Alustante'), " +
                    " ( 19, 'Angón'), " +
                    " ( 19, 'Anguita'), " +
                    " ( 19, 'Anquela del Ducado'), " +
                    " ( 19, 'Anquela del Pedregal'), " +
                    " ( 19, 'Aranzueque'), " +
                    " ( 19, 'Arbancón'), " +
                    " ( 19, 'Arbeteta'), " +
                    " ( 19, 'Argecilla'), " +
                    " ( 19, 'Armallones'), " +
                    " ( 19, 'Armuña de Tajuña'), " +
                    " ( 19, 'Arroyo de las Fraguas'), " +
                    " ( 19, 'Atanzón'), " +
                    " ( 19, 'Atienza'), " +
                    " ( 19, 'Auñón'), " +
                    " ( 19, 'Azuqueca de Henares'), " +
                    " ( 19, 'Baides'), " +
                    " ( 19, 'Baños de Tajo'), " +
                    " ( 19, 'Bañuelos'), " +
                    " ( 19, 'Barriopedro'), " +
                    " ( 19, 'Berninches'), " +
                    " ( 19, 'Bodera (La)'), " +
                    " ( 19, 'Brihuega'), " +
                    " ( 19, 'Budia'), " +
                    " ( 19, 'Bujalaro'), " +
                    " ( 19, 'Bustares'), " +
                    " ( 19, 'Cabanillas del Campo'), " +
                    " ( 19, 'Campillo de Dueñas'), " +
                    " ( 19, 'Campillo de Ranas'), " +
                    " ( 19, 'Campisábalos'), " +
                    " ( 19, 'Canredondo'), " +
                    " ( 19, 'Cantalojas'), " +
                    " ( 19, 'Cañizar'), " +
                    " ( 19, 'Cardoso de la Sierra (El)'), " +
                    " ( 19, 'Casa de Uceda'), " +
                    " ( 19, 'Casar (El)'), " +
                    " ( 19, 'Casas de San Galindo'), " +
                    " ( 19, 'Caspueñas'), " +
                    " ( 19, 'Castejón de Henares'), " +
                    " ( 19, 'Castellar de la Muela'), " +
                    " ( 19, 'Castilforte'), " +
                    " ( 19, 'Castilnuevo'), " +
                    " ( 19, 'Cendejas de Enmedio'), " +
                    " ( 19, 'Cendejas de la Torre'), " +
                    " ( 19, 'Centenera'), " +
                    " ( 19, 'Checa'), " +
                    " ( 19, 'Chequilla'), " +
                    " ( 19, 'Chillarón del Rey'), " +
                    " ( 19, 'Chiloeches'), " +
                    " ( 19, 'Cifuentes'), " +
                    " ( 19, 'Cincovillas'), " +
                    " ( 19, 'Ciruelas'), " +
                    " ( 19, 'Ciruelos del Pinar'), " +
                    " ( 19, 'Cobeta'), " +
                    " ( 19, 'Cogollor'), " +
                    " ( 19, 'Cogolludo'), " +
                    " ( 19, 'Condemios de Abajo'), " +
                    " ( 19, 'Condemios de Arriba'), " +
                    " ( 19, 'Congostrina'), " +
                    " ( 19, 'Copernal'), " +
                    " ( 19, 'Corduente'), " +
                    " ( 19, 'Cubillo de Uceda (El)'), " +
                    " ( 19, 'Driebes'), " +
                    " ( 19, 'Durón'), " +
                    " ( 19, 'Embid'), " +
                    " ( 19, 'Escamilla'), " +
                    " ( 19, 'Escariche'), " +
                    " ( 19, 'Escopete'), " +
                    " ( 19, 'Espinosa de Henares'), " +
                    " ( 19, 'Esplegares'), " +
                    " ( 19, 'Establés'), " +
                    " ( 19, 'Estriégana'), " +
                    " ( 19, 'Fontanar'), " +
                    " ( 19, 'Fuembellida'), " +
                    " ( 19, 'Fuencemillán'), " +
                    " ( 19, 'Fuentelahiguera de Albatages'), " +
                    " ( 19, 'Fuentelencina'), " +
                    " ( 19, 'Fuentelsaz'), " +
                    " ( 19, 'Fuentelviejo'), " +
                    " ( 19, 'Fuentenovilla'), " +
                    " ( 19, 'Gajanejos'), " +
                    " ( 19, 'Galápagos'), " +
                    " ( 19, 'Galve de Sorbe'), " +
                    " ( 19, 'Gascueña de Bornova'), " +
                    " ( 19, 'Guadalajara'), " +
                    " ( 19, 'Henche'), " +
                    " ( 19, 'Heras de Ayuso'), " +
                    " ( 19, 'Herrería'), " +
                    " ( 19, 'Hiendelaencina'), " +
                    " ( 19, 'Hijes'), " +
                    " ( 19, 'Hita'), " +
                    " ( 19, 'Hombrados'), " +
                    " ( 19, 'Hontoba'), " +
                    " ( 19, 'Horche'), " +
                    " ( 19, 'Hortezuela de Océn'), " +
                    " ( 19, 'Huerce (La)'), " +
                    " ( 19, 'Huérmeces del Cerro'), " +
                    " ( 19, 'Huertahernando'), " +
                    " ( 19, 'Hueva'), " +
                    " ( 19, 'Humanes'), " +
                    " ( 19, 'Illana'), " +
                    " ( 19, 'Iniéstola'), " +
                    " ( 19, 'Inviernas (Las)'), " +
                    " ( 19, 'Irueste'), " +
                    " ( 19, 'Jadraque'), " +
                    " ( 19, 'Jirueque'), " +
                    " ( 19, 'Ledanca'), " +
                    " ( 19, 'Loranca de Tajuña'), " +
                    " ( 19, 'Lupiana'), " +
                    " ( 19, 'Luzaga'), " +
                    " ( 19, 'Luzón'), " +
                    " ( 19, 'Majaelrayo'), " +
                    " ( 19, 'Málaga del Fresno'), " +
                    " ( 19, 'Malaguilla'), " +
                    " ( 19, 'Mandayona'), " +
                    " ( 19, 'Mantiel'), " +
                    " ( 19, 'Maranchón'), " +
                    " ( 19, 'Marchamalo'), " +
                    " ( 19, 'Masegoso de Tajuña'), " +
                    " ( 19, 'Matarrubia'), " +
                    " ( 19, 'Matillas'), " +
                    " ( 19, 'Mazarete'), " +
                    " ( 19, 'Mazuecos'), " +
                    " ( 19, 'Medranda'), " +
                    " ( 19, 'Megina'), " +
                    " ( 19, 'Membrillera'), " +
                    " ( 19, 'Miedes de Atienza'), " +
                    " ( 19, 'Mierla (La)'), " +
                    " ( 19, 'Millana'), " +
                    " ( 19, 'Milmarcos'), " +
                    " ( 19, 'Miñosa (La)'), " +
                    " ( 19, 'Mirabueno'), " +
                    " ( 19, 'Miralrío'), " +
                    " ( 19, 'Mochales'), " +
                    " ( 19, 'Mohernando'), " +
                    " ( 19, 'Molina de Aragón'), " +
                    " ( 19, 'Monasterio'), " +
                    " ( 19, 'Mondéjar'), " +
                    " ( 19, 'Montarrón'), " +
                    " ( 19, 'Moratilla de los Meleros'), " +
                    " ( 19, 'Morenilla'), " +
                    " ( 19, 'Muduex'), " +
                    " ( 19, 'Navas de Jadraque (Las)'), " +
                    " ( 19, 'Negredo'), " +
                    " ( 19, 'Ocentejo'), " +
                    " ( 19, 'Olivar (El)'), " +
                    " ( 19, 'Olmeda de Cobeta'), " +
                    " ( 19, 'Olmeda de Jadraque (La)'), " +
                    " ( 19, 'Ordial (El)'), " +
                    " ( 19, 'Orea'), " +
                    " ( 19, 'Pálmaces de Jadraque'), " +
                    " ( 19, 'Pardos'), " +
                    " ( 19, 'Paredes de Sigüenza'), " +
                    " ( 19, 'Pareja'), " +
                    " ( 19, 'Pastrana'), " +
                    " ( 19, 'Pedregal (El)'), " +
                    " ( 19, 'Peñalén'), " +
                    " ( 19, 'Peñalver'), " +
                    " ( 19, 'Peralejos de las Truchas'), " +
                    " ( 19, 'Peralveche'), " +
                    " ( 19, 'Pinilla de Jadraque'), " +
                    " ( 19, 'Pinilla de Molina'), " +
                    " ( 19, 'Pioz'), " +
                    " ( 19, 'Piqueras'), " +
                    " ( 19, 'Pobo de Dueñas (El)'), " +
                    " ( 19, 'Poveda de la Sierra'), " +
                    " ( 19, 'Pozo de Almoguera'), " +
                    " ( 19, 'Pozo de Guadalajara'), " +
                    " ( 19, 'Prádena de Atienza'), " +
                    " ( 19, 'Prados Redondos'), " +
                    " ( 19, 'Puebla de Beleña'), " +
                    " ( 19, 'Puebla de Valles'), " +
                    " ( 19, 'Quer'), " +
                    " ( 19, 'Rebollosa de Jadraque'), " +
                    " ( 19, 'Recuenco (El)'), " +
                    " ( 19, 'Renera'), " +
                    " ( 19, 'Retiendas'), " +
                    " ( 19, 'Riba de Saelices'), " +
                    " ( 19, 'Rillo de Gallo'), " +
                    " ( 19, 'Riofrío del Llano'), " +
                    " ( 19, 'Robledillo de Mohernando'), " +
                    " ( 19, 'Robledo de Corpes'), " +
                    " ( 19, 'Romanillos de Atienza'), " +
                    " ( 19, 'Romanones'), " +
                    " ( 19, 'Rueda de la Sierra'), " +
                    " ( 19, 'Sacecorbo'), " +
                    " ( 19, 'Sacedón'), " +
                    " ( 19, 'Saelices de la Sal'), " +
                    " ( 19, 'Salmerón'), " +
                    " ( 19, 'San Andrés del Congosto'), " +
                    " ( 19, 'San Andrés del Rey'), " +
                    " ( 19, 'Santiuste'), " +
                    " ( 19, 'Saúca'), " +
                    " ( 19, 'Sayatón'), " +
                    " ( 19, 'Selas'), " +
                    " ( 19, 'Semillas'), " +
                    " ( 19, 'Setiles'), " +
                    " ( 19, 'Sienes'), " +
                    " ( 19, 'Sigüenza'), " +
                    " ( 19, 'Solanillos del Extremo'), " +
                    " ( 19, 'Somolinos'), " +
                    " ( 19, 'Sotillo (El)'), " +
                    " ( 19, 'Sotodosos'), " +
                    " ( 19, 'Tamajón'), " +
                    " ( 19, 'Taragudo'), " +
                    " ( 19, 'Taravilla'), " +
                    " ( 19, 'Tartanedo'), " +
                    " ( 19, 'Tendilla'), " +
                    " ( 19, 'Terzaga'), " +
                    " ( 19, 'Tierzo'), " +
                    " ( 19, 'Toba (La)'), " +
                    " ( 19, 'Tordellego'), " +
                    " ( 19, 'Tordelrábano'), " +
                    " ( 19, 'Tordesilos'), " +
                    " ( 19, 'Torija'), " +
                    " ( 19, 'Torre del Burgo'), " +
                    " ( 19, 'Torrecuadrada de Molina'), " +
                    " ( 19, 'Torrecuadradilla'), " +
                    " ( 19, 'Torrejón del Rey'), " +
                    " ( 19, 'Torremocha de Jadraque'), " +
                    " ( 19, 'Torremocha del Campo'), " +
                    " ( 19, 'Torremocha del Pinar'), " +
                    " ( 19, 'Torremochuela'), " +
                    " ( 19, 'Torrubia'), " +
                    " ( 19, 'Tórtola de Henares'), " +
                    " ( 19, 'Tortuera'), " +
                    " ( 19, 'Tortuero'), " +
                    " ( 19, 'Traíd'), " +
                    " ( 19, 'Trijueque'), " +
                    " ( 19, 'Trillo'), " +
                    " ( 19, 'Uceda'), " +
                    " ( 19, 'Ujados'), " +
                    " ( 19, 'Utande'), " +
                    " ( 19, 'Valdarachas'), " +
                    " ( 19, 'Valdearenas'), " +
                    " ( 19, 'Valdeavellano'), " +
                    " ( 19, 'Valdeaveruelo'), " +
                    " ( 19, 'Valdeconcha'), " +
                    " ( 19, 'Valdegrudas'), " +
                    " ( 19, 'Valdelcubo'), " +
                    " ( 19, 'Valdenuño Fernández'), " +
                    " ( 19, 'Valdepeñas de la Sierra'), " +
                    " ( 19, 'Valderrebollo'), " +
                    " ( 19, 'Valdesotos'), " +
                    " ( 19, 'Valfermoso de Tajuña'), " +
                    " ( 19, 'Valhermoso'), " +
                    " ( 19, 'Valtablado del Río'), " +
                    " ( 19, 'Valverde de los Arroyos'), " +
                    " ( 19, 'Viana de Jadraque'), " +
                    " ( 19, 'Villanueva de Alcorón'), " +
                    " ( 19, 'Villanueva de Argecilla'), " +
                    " ( 19, 'Villanueva de la Torre'), " +
                    " ( 19, 'Villares de Jadraque'), " +
                    " ( 19, 'Villaseca de Henares'), " +
                    " ( 19, 'Villaseca de Uceda'), " +
                    " ( 19, 'Villel de Mesa'), " +
                    " ( 19, 'Viñuelas'), " +
                    " ( 19, 'Yebes'), " +
                    " ( 19, 'Yebra'), " +
                    " ( 19, 'Yélamos de Abajo'), " +
                    " ( 19, 'Yélamos de Arriba'), " +
                    " ( 19, 'Yunquera de Henares'), " +
                    " ( 19, 'Yunta (La)'), " +
                    " ( 19, 'Zaorejas'), " +
                    " ( 19, 'Zarzuela de Jadraque'), " +
                    " ( 19, 'Zorita de los Canes'), " +
                    " ( 20, 'Abaltzisketa'), " +
                    " ( 20, 'Aduna'), " +
                    " ( 20, 'Aia'), " +
                    " ( 20, 'Aizarnazabal'), " +
                    " ( 20, 'Albiztur'), " +
                    " ( 20, 'Alegia'), " +
                    " ( 20, 'Alkiza'), " +
                    " ( 20, 'Altzaga'), " +
                    " ( 20, 'Altzo'), " +
                    " ( 20, 'Amezketa'), " +
                    " ( 20, 'Andoain'), " +
                    " ( 20, 'Anoeta'), " +
                    " ( 20, 'Antzuola'), " +
                    " ( 20, 'Arama'), " +
                    " ( 20, 'Aretxabaleta'), " +
                    " ( 20, 'Arrasate/Mondragón'), " +
                    " ( 20, 'Asteasu'), " +
                    " ( 20, 'Astigarraga'), " +
                    " ( 20, 'Ataun'), " +
                    " ( 20, 'Azkoitia'), " +
                    " ( 20, 'Azpeitia'), " +
                    " ( 20, 'Baliarrain'), " +
                    " ( 20, 'Beasain'), " +
                    " ( 20, 'Beizama'), " +
                    " ( 20, 'Belauntza'), " +
                    " ( 20, 'Berastegi'), " +
                    " ( 20, 'Bergara'), " +
                    " ( 20, 'Berrobi'), " +
                    " ( 20, 'Bidegoian'), " +
                    " ( 20, 'Deba'), " +
                    " ( 20, 'Donostia-San Sebastián'), " +
                    " ( 20, 'Eibar'), " +
                    " ( 20, 'Elduain'), " +
                    " ( 20, 'Elgeta'), " +
                    " ( 20, 'Elgoibar'), " +
                    " ( 20, 'Errenteria'), " +
                    " ( 20, 'Errezil'), " +
                    " ( 20, 'Eskoriatza'), " +
                    " ( 20, 'Ezkio-Itsaso'), " +
                    " ( 20, 'Gabiria'), " +
                    " ( 20, 'Gaintza'), " +
                    " ( 20, 'Gaztelu'), " +
                    " ( 20, 'Getaria'), " +
                    " ( 20, 'Hernani'), " +
                    " ( 20, 'Hernialde'), " +
                    " ( 20, 'Hondarribia'), " +
                    " ( 20, 'Ibarra'), " +
                    " ( 20, 'Idiazabal'), " +
                    " ( 20, 'Ikaztegieta'), " +
                    " ( 20, 'Irun'), " +
                    " ( 20, 'Irura'), " +
                    " ( 20, 'Itsasondo'), " +
                    " ( 20, 'Larraul'), " +
                    " ( 20, 'Lasarte-Oria'), " +
                    " ( 20, 'Lazkao'), " +
                    " ( 20, 'Leaburu'), " +
                    " ( 20, 'Legazpi'), " +
                    " ( 20, 'Legorreta'), " +
                    " ( 20, 'Leintz-Gatzaga'), " +
                    " ( 20, 'Lezo'), " +
                    " ( 20, 'Lizartza'), " +
                    " ( 20, 'Mendaro'), " +
                    " ( 20, 'Mutiloa'), " +
                    " ( 20, 'Mutriku'), " +
                    " ( 20, 'Oiartzun'), " +
                    " ( 20, 'Olaberria'), " +
                    " ( 20, 'Oñati'), " +
                    " ( 20, 'Ordizia'), " +
                    " ( 20, 'Orendain'), " +
                    " ( 20, 'Orexa'), " +
                    " ( 20, 'Orio'), " +
                    " ( 20, 'Ormaiztegi'), " +
                    " ( 20, 'Pasaia'), " +
                    " ( 20, 'Segura'), " +
                    " ( 20, 'Soraluze/Placencia de las Armas'), " +
                    " ( 20, 'Tolosa'), " +
                    " ( 20, 'Urnieta'), " +
                    " ( 20, 'Urretxu'), " +
                    " ( 20, 'Usurbil'), " +
                    " ( 20, 'Villabona'), " +
                    " ( 20, 'Zaldibia'), " +
                    " ( 20, 'Zarautz'), " +
                    " ( 20, 'Zegama'), " +
                    " ( 20, 'Zerain'), " +
                    " ( 20, 'Zestoa'), " +
                    " ( 20, 'Zizurkil'), " +
                    " ( 20, 'Zumaia'), " +
                    " ( 20, 'Zumarraga'), " +
                    " ( 21, 'Alájar'), " +
                    " ( 21, 'Aljaraque'), " +
                    " ( 21, 'Almendro (El)'), " +
                    " ( 21, 'Almonaster la Real'), " +
                    " ( 21, 'Almonte'), " +
                    " ( 21, 'Alosno'), " +
                    " ( 21, 'Aracena'), " +
                    " ( 21, 'Aroche'), " +
                    " ( 21, 'Arroyomolinos de León'), " +
                    " ( 21, 'Ayamonte'), " +
                    " ( 21, 'Beas'), " +
                    " ( 21, 'Berrocal'), " +
                    " ( 21, 'Bollullos Par del Condado'), " +
                    " ( 21, 'Bonares'), " +
                    " ( 21, 'Cabezas Rubias'), " +
                    " ( 21, 'Cala'), " +
                    " ( 21, 'Calañas'), " +
                    " ( 21, 'Campillo (El)'), " +
                    " ( 21, 'Campofrío'), " +
                    " ( 21, 'Cañaveral de León'), " +
                    " ( 21, 'Cartaya'), " +
                    " ( 21, 'Castaño del Robledo'), " +
                    " ( 21, 'Cerro de Andévalo (El)'), " +
                    " ( 21, 'Chucena'), " +
                    " ( 21, 'Corteconcepción'), " +
                    " ( 21, 'Cortegana'), " +
                    " ( 21, 'Cortelazor'), " +
                    " ( 21, 'Cumbres de Enmedio'), " +
                    " ( 21, 'Cumbres de San Bartolomé'), " +
                    " ( 21, 'Cumbres Mayores'), " +
                    " ( 21, 'Encinasola'), " +
                    " ( 21, 'Escacena del Campo'), " +
                    " ( 21, 'Fuenteheridos'), " +
                    " ( 21, 'Galaroza'), " +
                    " ( 21, 'Gibraleón'), " +
                    " ( 21, 'Granada de Río-Tinto (La)'), " +
                    " ( 21, 'Granado (El)'), " +
                    " ( 21, 'Higuera de la Sierra'), " +
                    " ( 21, 'Hinojales'), " +
                    " ( 21, 'Hinojos'), " +
                    " ( 21, 'Huelva'), " +
                    " ( 21, 'Isla Cristina'), " +
                    " ( 21, 'Jabugo'), " +
                    " ( 21, 'Lepe'), " +
                    " ( 21, 'Linares de la Sierra'), " +
                    " ( 21, 'Lucena del Puerto'), " +
                    " ( 21, 'Manzanilla'), " +
                    " ( 21, 'Marines (Los)'), " +
                    " ( 21, 'Minas de Riotinto'), " +
                    " ( 21, 'Moguer'), " +
                    " ( 21, 'Nava (La)'), " +
                    " ( 21, 'Nerva'), " +
                    " ( 21, 'Niebla'), " +
                    " ( 21, 'Palma del Condado (La)'), " +
                    " ( 21, 'Palos de la Frontera'), " +
                    " ( 21, 'Paterna del Campo'), " +
                    " ( 21, 'Paymogo'), " +
                    " ( 21, 'Puebla de Guzmán'), " +
                    " ( 21, 'Puerto Moral'), " +
                    " ( 21, 'Punta Umbría'), " +
                    " ( 21, 'Rociana del Condado'), " +
                    " ( 21, 'Rosal de la Frontera'), " +
                    " ( 21, 'San Bartolomé de la Torre'), " +
                    " ( 21, 'San Juan del Puerto'), " +
                    " ( 21, 'San Silvestre de Guzmán'), " +
                    " ( 21, 'Sanlúcar de Guadiana'), " +
                    " ( 21, 'Santa Ana la Real'), " +
                    " ( 21, 'Santa Bárbara de Casa'), " +
                    " ( 21, 'Santa Olalla del Cala'), " +
                    " ( 21, 'Trigueros'), " +
                    " ( 21, 'Valdelarco'), " +
                    " ( 21, 'Valverde del Camino'), " +
                    " ( 21, 'Villablanca'), " +
                    " ( 21, 'Villalba del Alcor'), " +
                    " ( 21, 'Villanueva de las Cruces'), " +
                    " ( 21, 'Villanueva de los Castillejos'), " +
                    " ( 21, 'Villarrasa'), " +
                    " ( 21, 'Zalamea la Real'), " +
                    " ( 21, 'Zufre'), " +
                    " ( 22, 'Abiego'), " +
                    " ( 22, 'Abizanda'), " +
                    " ( 22, 'Adahuesca'), " +
                    " ( 22, 'Agüero'), " +
                    " ( 22, 'Aínsa-Sobrarbe'), " +
                    " ( 22, 'Aisa'), " +
                    " ( 22, 'Albalate de Cinca'), " +
                    " ( 22, 'Albalatillo'), " +
                    " ( 22, 'Albelda'), " +
                    " ( 22, 'Albero Alto'), " +
                    " ( 22, 'Albero Bajo'), " +
                    " ( 22, 'Alberuela de Tubo'), " +
                    " ( 22, 'Alcalá de Gurrea'), " +
                    " ( 22, 'Alcalá del Obispo'), " +
                    " ( 22, 'Alcampell'), " +
                    " ( 22, 'Alcolea de Cinca'), " +
                    " ( 22, 'Alcubierre'), " +
                    " ( 22, 'Alerre'), " +
                    " ( 22, 'Alfántega'), " +
                    " ( 22, 'Almudévar'), " +
                    " ( 22, 'Almunia de San Juan'), " +
                    " ( 22, 'Almuniente'), " +
                    " ( 22, 'Alquézar'), " +
                    " ( 22, 'Altorricón'), " +
                    " ( 22, 'Angüés'), " +
                    " ( 22, 'Ansó'), " +
                    " ( 22, 'Antillón'), " +
                    " ( 22, 'Aragüés del Puerto'), " +
                    " ( 22, 'Arén'), " +
                    " ( 22, 'Argavieso'), " +
                    " ( 22, 'Arguis'), " +
                    " ( 22, 'Ayerbe'), " +
                    " ( 22, 'Azanuy-Alins'), " +
                    " ( 22, 'Azara'), " +
                    " ( 22, 'Azlor'), " +
                    " ( 22, 'Baélls'), " +
                    " ( 22, 'Bailo'), " +
                    " ( 22, 'Baldellou'), " +
                    " ( 22, 'Ballobar'), " +
                    " ( 22, 'Banastás'), " +
                    " ( 22, 'Barbastro'), " +
                    " ( 22, 'Barbués'), " +
                    " ( 22, 'Barbuñales'), " +
                    " ( 22, 'Bárcabo'), " +
                    " ( 22, 'Belver de Cinca'), " +
                    " ( 22, 'Benabarre'), " +
                    " ( 22, 'Benasque'), " +
                    " ( 22, 'Berbegal'), " +
                    " ( 22, 'Bielsa'), " +
                    " ( 22, 'Bierge'), " +
                    " ( 22, 'Biescas'), " +
                    " ( 22, 'Binaced'), " +
                    " ( 22, 'Binéfar'), " +
                    " ( 22, 'Bisaurri'), " +
                    " ( 22, 'Biscarrués'), " +
                    " ( 22, 'Blecua y Torres'), " +
                    " ( 22, 'Boltaña'), " +
                    " ( 22, 'Bonansa'), " +
                    " ( 22, 'Borau'), " +
                    " ( 22, 'Broto'), " +
                    " ( 22, 'Caldearenas'), " +
                    " ( 22, 'Campo'), " +
                    " ( 22, 'Camporrélls'), " +
                    " ( 22, 'Canal de Berdún'), " +
                    " ( 22, 'Candasnos'), " +
                    " ( 22, 'Canfranc'), " +
                    " ( 22, 'Capdesaso'), " +
                    " ( 22, 'Capella'), " +
                    " ( 22, 'Casbas de Huesca'), " +
                    " ( 22, 'Castejón de Monegros'), " +
                    " ( 22, 'Castejón de Sos'), " +
                    " ( 22, 'Castejón del Puente'), " +
                    " ( 22, 'Castelflorite'), " +
                    " ( 22, 'Castiello de Jaca'), " +
                    " ( 22, 'Castigaleu'), " +
                    " ( 22, 'Castillazuelo'), " +
                    " ( 22, 'Castillonroy'), " +
                    " ( 22, 'Chalamera'), " +
                    " ( 22, 'Chía'), " +
                    " ( 22, 'Chimillas'), " +
                    " ( 22, 'Colungo'), " +
                    " ( 22, 'Esplús'), " +
                    " ( 22, 'Estada'), " +
                    " ( 22, 'Estadilla'), " +
                    " ( 22, 'Estopiñán del Castillo'), " +
                    " ( 22, 'Fago'), " +
                    " ( 22, 'Fanlo'), " +
                    " ( 22, 'Fiscal'), " +
                    " ( 22, 'Fonz'), " +
                    " ( 22, 'Foradada del Toscar'), " +
                    " ( 22, 'Fraga'), " +
                    " ( 22, 'Fueva (La)'), " +
                    " ( 22, 'Gistaín'), " +
                    " ( 22, 'Grado (El)'), " +
                    " ( 22, 'Grañén'), " +
                    " ( 22, 'Graus'), " +
                    " ( 22, 'Gurrea de Gállego'), " +
                    " ( 22, 'Hoz de Jaca'), " +
                    " ( 22, 'Hoz y Costean'), " +
                    " ( 22, 'Huerto'), " +
                    " ( 22, 'Huesca'), " +
                    " ( 22, 'Ibieca'), " +
                    " ( 22, 'Igriés'), " +
                    " ( 22, 'Ilche'), " +
                    " ( 22, 'Isábena'), " +
                    " ( 22, 'Jaca'), " +
                    " ( 22, 'Jasa'), " +
                    " ( 22, 'Labuerda'), " +
                    " ( 22, 'Laluenga'), " +
                    " ( 22, 'Lalueza'), " +
                    " ( 22, 'Lanaja'), " +
                    " ( 22, 'Laperdiguera'), " +
                    " ( 22, 'Lascellas-Ponzano'), " +
                    " ( 22, 'Lascuarre'), " +
                    " ( 22, 'Laspaúles'), " +
                    " ( 22, 'Laspuña'), " +
                    " ( 22, 'Loarre'), " +
                    " ( 22, 'Loporzano'), " +
                    " ( 22, 'Loscorrales'), " +
                    " ( 22, 'Lupiñén-Ortilla'), " +
                    " ( 22, 'Monesma y Cajigar'), " +
                    " ( 22, 'Monflorite-Lascasas'), " +
                    " ( 22, 'Montanuy'), " +
                    " ( 22, 'Monzón'), " +
                    " ( 22, 'Naval'), " +
                    " ( 22, 'Novales'), " +
                    " ( 22, 'Nueno'), " +
                    " ( 22, 'Olvena'), " +
                    " ( 22, 'Ontiñena'), " +
                    " ( 22, 'Osso de Cinca'), " +
                    " ( 22, 'Palo'), " +
                    " ( 22, 'Panticosa'), " +
                    " ( 22, 'Peñalba'), " +
                    " ( 22, 'Peñas de Riglos (Las)'), " +
                    " ( 22, 'Peralta de Alcofea'), " +
                    " ( 22, 'Peralta de Calasanz'), " +
                    " ( 22, 'Peraltilla'), " +
                    " ( 22, 'Perarrúa'), " +
                    " ( 22, 'Pertusa'), " +
                    " ( 22, 'Piracés'), " +
                    " ( 22, 'Plan'), " +
                    " ( 22, 'Poleñino'), " +
                    " ( 22, 'Pozán de Vero'), " +
                    " ( 22, 'Puebla de Castro (La)'), " +
                    " ( 22, 'Puente de Montañana'), " +
                    " ( 22, 'Puente la Reina de Jaca'), " +
                    " ( 22, 'Puértolas'), " +
                    " ( 22, 'Pueyo de Araguás (El)'), " +
                    " ( 22, 'Pueyo de Santa Cruz'), " +
                    " ( 22, 'Quicena'), " +
                    " ( 22, 'Robres'), " +
                    " ( 22, 'Sabiñánigo'), " +
                    " ( 22, 'Sahún'), " +
                    " ( 22, 'Salas Altas'), " +
                    " ( 22, 'Salas Bajas'), " +
                    " ( 22, 'Salillas'), " +
                    " ( 22, 'Sallent de Gállego'), " +
                    " ( 22, 'San Esteban de Litera'), " +
                    " ( 22, 'San Juan de Plan'), " +
                    " ( 22, 'San Miguel del Cinca'), " +
                    " ( 22, 'Sangarrén'), " +
                    " ( 22, 'Santa Cilia'), " +
                    " ( 22, 'Santa Cruz de la Serós'), " +
                    " ( 22, 'Santa María de Dulcis'), " +
                    " ( 22, 'Santaliestra y San Quílez'), " +
                    " ( 22, 'Sariñena'), " +
                    " ( 22, 'Secastilla'), " +
                    " ( 22, 'Seira'), " +
                    " ( 22, 'Sena'), " +
                    " ( 22, 'Senés de Alcubierre'), " +
                    " ( 22, 'Sesa'), " +
                    " ( 22, 'Sesué'), " +
                    " ( 22, 'Siétamo'), " +
                    " ( 22, 'Sopeira'), " +
                    " ( 22, 'Sotonera (La)'), " +
                    " ( 22, 'Tamarite de Litera'), " +
                    " ( 22, 'Tardienta'), " +
                    " ( 22, 'Tella-Sin'), " +
                    " ( 22, 'Tierz'), " +
                    " ( 22, 'Tolva'), " +
                    " ( 22, 'Torla'), " +
                    " ( 22, 'Torralba de Aragón'), " +
                    " ( 22, 'Torre la Ribera'), " +
                    " ( 22, 'Torrente de Cinca'), " +
                    " ( 22, 'Torres de Alcanadre'), " +
                    " ( 22, 'Torres de Barbués'), " +
                    " ( 22, 'Tramaced'), " +
                    " ( 22, 'Valfarta'), " +
                    " ( 22, 'Valle de Bardají'), " +
                    " ( 22, 'Valle de Hecho'), " +
                    " ( 22, 'Valle de Lierp'), " +
                    " ( 22, 'Velilla de Cinca'), " +
                    " ( 22, 'Vencillón'), " +
                    " ( 22, 'Veracruz'), " +
                    " ( 22, 'Viacamp y Litera'), " +
                    " ( 22, 'Vicién'), " +
                    " ( 22, 'Villanova'), " +
                    " ( 22, 'Villanúa'), " +
                    " ( 22, 'Villanueva de Sigena'), " +
                    " ( 22, 'Yebra de Basa'), " +
                    " ( 22, 'Yésero'), " +
                    " ( 22, 'Zaidín'), " +
                    " ( 23, 'Albanchez de Mágina'), " +
                    " ( 23, 'Alcalá la Real'), " +
                    " ( 23, 'Alcaudete'), " +
                    " ( 23, 'Aldeaquemada'), " +
                    " ( 23, 'Andújar'), " +
                    " ( 23, 'Arjona'), " +
                    " ( 23, 'Arjonilla'), " +
                    " ( 23, 'Arquillos'), " +
                    " ( 23, 'Arroyo del Ojanco'), " +
                    " ( 23, 'Baeza'), " +
                    " ( 23, 'Bailén'), " +
                    " ( 23, 'Baños de la Encina'), " +
                    " ( 23, 'Beas de Segura'), " +
                    " ( 23, 'Bedmar y Garcíez'), " +
                    " ( 23, 'Begíjar'), " +
                    " ( 23, 'Bélmez de la Moraleda'), " +
                    " ( 23, 'Benatae'), " +
                    " ( 23, 'Cabra del Santo Cristo'), " +
                    " ( 23, 'Cambil'), " +
                    " ( 23, 'Campillo de Arenas'), " +
                    " ( 23, 'Canena'), " +
                    " ( 23, 'Carboneros'), " +
                    " ( 23, 'Cárcheles'), " +
                    " ( 23, 'Carolina (La)'), " +
                    " ( 23, 'Castellar'), " +
                    " ( 23, 'Castillo de Locubín'), " +
                    " ( 23, 'Cazalilla'), " +
                    " ( 23, 'Cazorla'), " +
                    " ( 23, 'Chiclana de Segura'), " +
                    " ( 23, 'Chilluévar'), " +
                    " ( 23, 'Escañuela'), " +
                    " ( 23, 'Espelúy'), " +
                    " ( 23, 'Frailes'), " +
                    " ( 23, 'Fuensanta de Martos'), " +
                    " ( 23, 'Fuerte del Rey'), " +
                    " ( 23, 'Génave'), " +
                    " ( 23, 'Guardia de Jaén (La)'), " +
                    " ( 23, 'Guarromán'), " +
                    " ( 23, 'Higuera de Calatrava'), " +
                    " ( 23, 'Hinojares'), " +
                    " ( 23, 'Hornos'), " +
                    " ( 23, 'Huelma'), " +
                    " ( 23, 'Huesa'), " +
                    " ( 23, 'Ibros'), " +
                    " ( 23, 'Iruela (La)'), " +
                    " ( 23, 'Iznatoraf'), " +
                    " ( 23, 'Jabalquinto'), " +
                    " ( 23, 'Jaén'), " +
                    " ( 23, 'Jamilena'), " +
                    " ( 23, 'Jimena'), " +
                    " ( 23, 'Jódar'), " +
                    " ( 23, 'Lahiguera'), " +
                    " ( 23, 'Larva'), " +
                    " ( 23, 'Linares'), " +
                    " ( 23, 'Lopera'), " +
                    " ( 23, 'Lupión'), " +
                    " ( 23, 'Mancha Real'), " +
                    " ( 23, 'Marmolejo'), " +
                    " ( 23, 'Martos'), " +
                    " ( 23, 'Mengíbar'), " +
                    " ( 23, 'Montizón'), " +
                    " ( 23, 'Navas de San Juan'), " +
                    " ( 23, 'Noalejo'), " +
                    " ( 23, 'Orcera'), " +
                    " ( 23, 'Peal de Becerro'), " +
                    " ( 23, 'Pegalajar'), " +
                    " ( 23, 'Porcuna'), " +
                    " ( 23, 'Pozo Alcón'), " +
                    " ( 23, 'Puente de Génave'), " +
                    " ( 23, 'Puerta de Segura (La)'), " +
                    " ( 23, 'Quesada'), " +
                    " ( 23, 'Rus'), " +
                    " ( 23, 'Sabiote'), " +
                    " ( 23, 'Santa Elena'), " +
                    " ( 23, 'Santiago de Calatrava'), " +
                    " ( 23, 'Santiago-Pontones'), " +
                    " ( 23, 'Santisteban del Puerto'), " +
                    " ( 23, 'Santo Tomé'), " +
                    " ( 23, 'Segura de la Sierra'), " +
                    " ( 23, 'Siles'), " +
                    " ( 23, 'Sorihuela del Guadalimar'), " +
                    " ( 23, 'Torre del Campo'), " +
                    " ( 23, 'Torreblascopedro'), " +
                    " ( 23, 'Torredonjimeno'), " +
                    " ( 23, 'Torreperogil'), " +
                    " ( 23, 'Torres'), " +
                    " ( 23, 'Torres de Albánchez'), " +
                    " ( 23, 'Úbeda'), " +
                    " ( 23, 'Valdepeñas de Jaén'), " +
                    " ( 23, 'Vilches'), " +
                    " ( 23, 'Villacarrillo'), " +
                    " ( 23, 'Villanueva de la Reina'), " +
                    " ( 23, 'Villanueva del Arzobispo'), " +
                    " ( 23, 'Villardompardo'), " +
                    " ( 23, 'Villares (Los)'), " +
                    " ( 23, 'Villarrodrigo'), " +
                    " ( 23, 'Villatorres'), " +
                    " ( 24, 'Acebedo'), " +
                    " ( 24, 'Algadefe'), " +
                    " ( 24, 'Alija del Infantado'), " +
                    " ( 24, 'Almanza'), " +
                    " ( 24, 'Antigua (La)'), " +
                    " ( 24, 'Ardón'), " +
                    " ( 24, 'Arganza'), " +
                    " ( 24, 'Astorga'), " +
                    " ( 24, 'Balboa'), " +
                    " ( 24, 'Bañeza (La)'), " +
                    " ( 24, 'Barjas'), " +
                    " ( 24, 'Barrios de Luna (Los)'), " +
                    " ( 24, 'Bembibre'), " +
                    " ( 24, 'Benavides'), " +
                    " ( 24, 'Benuza'), " +
                    " ( 24, 'Bercianos del Páramo'), " +
                    " ( 24, 'Bercianos del Real Camino'), " +
                    " ( 24, 'Berlanga del Bierzo'), " +
                    " ( 24, 'Boca de Huérgano'), " +
                    " ( 24, 'Boñar'), " +
                    " ( 24, 'Borrenes'), " +
                    " ( 24, 'Brazuelo'), " +
                    " ( 24, 'Burgo Ranero (El)'), " +
                    " ( 24, 'Burón'), " +
                    " ( 24, 'Bustillo del Páramo'), " +
                    " ( 24, 'Cabañas Raras'), " +
                    " ( 24, 'Cabreros del Río'), " +
                    " ( 24, 'Cabrillanes'), " +
                    " ( 24, 'Cacabelos'), " +
                    " ( 24, 'Calzada del Coto'), " +
                    " ( 24, 'Campazas'), " +
                    " ( 24, 'Campo de Villavidel'), " +
                    " ( 24, 'Camponaraya'), " +
                    " ( 24, 'Candín'), " +
                    " ( 24, 'Cármenes'), " +
                    " ( 24, 'Carracedelo'), " +
                    " ( 24, 'Carrizo'), " +
                    " ( 24, 'Carrocera'), " +
                    " ( 24, 'Carucedo'), " +
                    " ( 24, 'Castilfalé'), " +
                    " ( 24, 'Castrillo de Cabrera'), " +
                    " ( 24, 'Castrillo de la Valduerna'), " +
                    " ( 24, 'Castrocalbón'), " +
                    " ( 24, 'Castrocontrigo'), " +
                    " ( 24, 'Castropodame'), " +
                    " ( 24, 'Castrotierra de Valmadrigal'), " +
                    " ( 24, 'Cea'), " +
                    " ( 24, 'Cebanico'), " +
                    " ( 24, 'Cebrones del Río'), " +
                    " ( 24, 'Chozas de Abajo'), " +
                    " ( 24, 'Cimanes de la Vega'), " +
                    " ( 24, 'Cimanes del Tejar'), " +
                    " ( 24, 'Cistierna'), " +
                    " ( 24, 'Congosto'), " +
                    " ( 24, 'Corbillos de los Oteros'), " +
                    " ( 24, 'Corullón'), " +
                    " ( 24, 'Crémenes'), " +
                    " ( 24, 'Cuadros'), " +
                    " ( 24, 'Cubillas de los Oteros'), " +
                    " ( 24, 'Cubillas de Rueda'), " +
                    " ( 24, 'Cubillos del Sil'), " +
                    " ( 24, 'Destriana'), " +
                    " ( 24, 'Encinedo'), " +
                    " ( 24, 'Ercina (La)'), " +
                    " ( 24, 'Escobar de Campos'), " +
                    " ( 24, 'Fabero'), " +
                    " ( 24, 'Folgoso de la Ribera'), " +
                    " ( 24, 'Fresno de la Vega'), " +
                    " ( 24, 'Fuentes de Carbajal'), " +
                    " ( 24, 'Garrafe de Torío'), " +
                    " ( 24, 'Gordaliza del Pino'), " +
                    " ( 24, 'Gordoncillo'), " +
                    " ( 24, 'Gradefes'), " +
                    " ( 24, 'Grajal de Campos'), " +
                    " ( 24, 'Gusendos de los Oteros'), " +
                    " ( 24, 'Hospital de Órbigo'), " +
                    " ( 24, 'Igüeña'), " +
                    " ( 24, 'Izagre'), " +
                    " ( 24, 'Joarilla de las Matas'), " +
                    " ( 24, 'Laguna Dalga'), " +
                    " ( 24, 'Laguna de Negrillos'), " +
                    " ( 24, 'León'), " +
                    " ( 24, 'Llamas de la Ribera'), " +
                    " ( 24, 'Lucillo'), " +
                    " ( 24, 'Luyego'), " +
                    " ( 24, 'Magaz de Cepeda'), " +
                    " ( 24, 'Mansilla de las Mulas'), " +
                    " ( 24, 'Mansilla Mayor'), " +
                    " ( 24, 'Maraña'), " +
                    " ( 24, 'Matadeón de los Oteros'), " +
                    " ( 24, 'Matallana de Torío'), " +
                    " ( 24, 'Matanza'), " +
                    " ( 24, 'Molinaseca'), " +
                    " ( 24, 'Murias de Paredes'), " +
                    " ( 24, 'Noceda del Bierzo'), " +
                    " ( 24, 'Oencia'), " +
                    " ( 24, 'Omañas (Las)'), " +
                    " ( 24, 'Onzonilla'), " +
                    " ( 24, 'Oseja de Sajambre'), " +
                    " ( 24, 'Pajares de los Oteros'), " +
                    " ( 24, 'Palacios de la Valduerna'), " +
                    " ( 24, 'Palacios del Sil'), " +
                    " ( 24, 'Páramo del Sil'), " +
                    " ( 24, 'Peranzanes'), " +
                    " ( 24, 'Pobladura de Pelayo García'), " +
                    " ( 24, 'Pola de Gordón (La)'), " +
                    " ( 24, 'Ponferrada'), " +
                    " ( 24, 'Posada de Valdeón'), " +
                    " ( 24, 'Pozuelo del Páramo'), " +
                    " ( 24, 'Prado de la Guzpeña'), " +
                    " ( 24, 'Priaranza del Bierzo'), " +
                    " ( 24, 'Prioro'), " +
                    " ( 24, 'Puebla de Lillo'), " +
                    " ( 24, 'Puente de Domingo Flórez'), " +
                    " ( 24, 'Quintana del Castillo'), " +
                    " ( 24, 'Quintana del Marco'), " +
                    " ( 24, 'Quintana y Congosto'), " +
                    " ( 24, 'Regueras de Arriba'), " +
                    " ( 24, 'Reyero'), " +
                    " ( 24, 'Riaño'), " +
                    " ( 24, 'Riego de la Vega'), " +
                    " ( 24, 'Riello'), " +
                    " ( 24, 'Rioseco de Tapia'), " +
                    " ( 24, 'Robla (La)'), " +
                    " ( 24, 'Roperuelos del Páramo'), " +
                    " ( 24, 'Sabero'), " +
                    " ( 24, 'Sahagún'), " +
                    " ( 24, 'San Adrián del Valle'), " +
                    " ( 24, 'San Andrés del Rabanedo'), " +
                    " ( 24, 'San Cristóbal de la Polantera'), " +
                    " ( 24, 'San Emiliano'), " +
                    " ( 24, 'San Esteban de Nogales'), " +
                    " ( 24, 'San Justo de la Vega'), " +
                    " ( 24, 'San Millán de los Caballeros'), " +
                    " ( 24, 'San Pedro Bercianos'), " +
                    " ( 24, 'Sancedo'), " +
                    " ( 24, 'Santa Colomba de Curueño'), " +
                    " ( 24, 'Santa Colomba de Somoza'), " +
                    " ( 24, 'Santa Cristina de Valmadrigal'), " +
                    " ( 24, 'Santa Elena de Jamuz'), " +
                    " ( 24, 'Santa María de la Isla'), " +
                    " ( 24, 'Santa María de Ordás'), " +
                    " ( 24, 'Santa María del Monte de Cea'), " +
                    " ( 24, 'Santa María del Páramo'), " +
                    " ( 24, 'Santa Marina del Rey'), " +
                    " ( 24, 'Santas Martas'), " +
                    " ( 24, 'Santiago Millas'), " +
                    " ( 24, 'Santovenia de la Valdoncina'), " +
                    " ( 24, 'Sariegos'), " +
                    " ( 24, 'Sena de Luna'), " +
                    " ( 24, 'Sobrado (León)'), " +
                    " ( 24, 'Soto de la Vega'), " +
                    " ( 24, 'Soto y Amío'), " +
                    " ( 24, 'Toral de los Guzmanes'), " +
                    " ( 24, 'Toreno'), " +
                    " ( 24, 'Torre del Bierzo'), " +
                    " ( 24, 'Trabadelo'), " +
                    " ( 24, 'Truchas'), " +
                    " ( 24, 'Turcia'), " +
                    " ( 24, 'Urdiales del Páramo'), " +
                    " ( 24, 'Val de San Lorenzo'), " +
                    " ( 24, 'Valdefresno'), " +
                    " ( 24, 'Valdefuentes del Páramo'), " +
                    " ( 24, 'Valdelugueros'), " +
                    " ( 24, 'Valdemora'), " +
                    " ( 24, 'Valdepiélago'), " +
                    " ( 24, 'Valdepolo'), " +
                    " ( 24, 'Valderas'), " +
                    " ( 24, 'Valderrey'), " +
                    " ( 24, 'Valderrueda'), " +
                    " ( 24, 'Valdesamario'), " +
                    " ( 24, 'Valdevimbre'), " +
                    " ( 24, 'Valencia de Don Juan'), " +
                    " ( 24, 'Vallecillo'), " +
                    " ( 24, 'Valverde de la Virgen'), " +
                    " ( 24, 'Valverde-Enrique'), " +
                    " ( 24, 'Vecilla (La)'), " +
                    " ( 24, 'Vega de Espinareda'), " +
                    " ( 24, 'Vega de Infanzones'), " +
                    " ( 24, 'Vega de Valcarce'), " +
                    " ( 24, 'Vegacervera'), " +
                    " ( 24, 'Vegaquemada'), " +
                    " ( 24, 'Vegas del Condado'), " +
                    " ( 24, 'Villablino'), " +
                    " ( 24, 'Villabraz'), " +
                    " ( 24, 'Villadangos del Páramo'), " +
                    " ( 24, 'Villadecanes'), " +
                    " ( 24, 'Villademor de la Vega'), " +
                    " ( 24, 'Villafranca del Bierzo'), " +
                    " ( 24, 'Villagatón'), " +
                    " ( 24, 'Villamandos'), " +
                    " ( 24, 'Villamanín'), " +
                    " ( 24, 'Villamañán'), " +
                    " ( 24, 'Villamartín de Don Sancho'), " +
                    " ( 24, 'Villamejil'), " +
                    " ( 24, 'Villamol'), " +
                    " ( 24, 'Villamontán de la Valduerna'), " +
                    " ( 24, 'Villamoratiel de las Matas'), " +
                    " ( 24, 'Villanueva de las Manzanas'), " +
                    " ( 24, 'Villaobispo de Otero'), " +
                    " ( 24, 'Villaornate y Castro'), " +
                    " ( 24, 'Villaquejida'), " +
                    " ( 24, 'Villaquilambre'), " +
                    " ( 24, 'Villarejo de Órbigo'), " +
                    " ( 24, 'Villares de Órbigo'), " +
                    " ( 24, 'Villasabariego'), " +
                    " ( 24, 'Villaselán'), " +
                    " ( 24, 'Villaturiel'), " +
                    " ( 24, 'Villazala'), " +
                    " ( 24, 'Villazanzo de Valderaduey'), " +
                    " ( 24, 'Zotes del Páramo'), " +
                    " ( 25, 'Abella de la Conca'), " +
                    " ( 25, 'Àger'), " +
                    " ( 25, 'Agramunt'), " +
                    " ( 25, 'Aitona'), " +
                    " ( 25, 'Alamús (Els)'), " +
                    " ( 25, 'Alàs i Cerc'), " +
                    " ( 25, 'Albagés (L'')'), " +
                    " ( 25, 'Albatàrrec'), " +
                    " ( 25, 'Albesa'), " +
                    " ( 25, 'Albi (L'')'), " +
                    " ( 25, 'Alcanó'), " +
                    " ( 25, 'Alcarràs'), " +
                    " ( 25, 'Alcoletge'), " +
                    " ( 25, 'Alfarràs'), " +
                    " ( 25, 'Alfés'), " +
                    " ( 25, 'Algerri'), " +
                    " ( 25, 'Alguaire'), " +
                    " ( 25, 'Alins'), " +
                    " ( 25, 'Almacelles'), " +
                    " ( 25, 'Almatret'), " +
                    " ( 25, 'Almenar'), " +
                    " ( 25, 'Alòs de Balaguer'), " +
                    " ( 25, 'Alpicat'), " +
                    " ( 25, 'Alt Àneu'), " +
                    " ( 25, 'Anglesola'), " +
                    " ( 25, 'Arbeca'), " +
                    " ( 25, 'Arres'), " +
                    " ( 25, 'Arsèguel'), " +
                    " ( 25, 'Artesa de Lleida'), " +
                    " ( 25, 'Artesa de Segre'), " +
                    " ( 25, 'Aspa'), " +
                    " ( 25, 'Avellanes i Santa Linya (Les)'), " +
                    " ( 25, 'Baix Pallars'), " +
                    " ( 25, 'Balaguer'), " +
                    " ( 25, 'Barbens'), " +
                    " ( 25, 'Baronia de Rialb (La)'), " +
                    " ( 25, 'Bassella'), " +
                    " ( 25, 'Bausen'), " +
                    " ( 25, 'Belianes'), " +
                    " ( 25, 'Bellaguarda'), " +
                    " ( 25, 'Bellcaire d''Urgell'), " +
                    " ( 25, 'Bell-lloc d''Urgell'), " +
                    " ( 25, 'Bellmunt d''Urgell'), " +
                    " ( 25, 'Bellpuig'), " +
                    " ( 25, 'Bellver de Cerdanya'), " +
                    " ( 25, 'Bellvís'), " +
                    " ( 25, 'Benavent de Segrià'), " +
                    " ( 25, 'Biosca'), " +
                    " ( 25, 'Bòrdes (Es)'), " +
                    " ( 25, 'Borges Blanques (Les)'), " +
                    " ( 25, 'Bossòst'), " +
                    " ( 25, 'Bovera'), " +
                    " ( 25, 'Cabanabona'), " +
                    " ( 25, 'Cabó'), " +
                    " ( 25, 'Camarasa'), " +
                    " ( 25, 'Canejan'), " +
                    " ( 25, 'Castell de Mur'), " +
                    " ( 25, 'Castellar de la Ribera'), " +
                    " ( 25, 'Castelldans'), " +
                    " ( 25, 'Castellnou de Seana'), " +
                    " ( 25, 'Castelló de Farfanya'), " +
                    " ( 25, 'Castellserà'), " +
                    " ( 25, 'Cava'), " +
                    " ( 25, 'Cervera'), " +
                    " ( 25, 'Cervià de les Garrigues'), " +
                    " ( 25, 'Ciutadilla'), " +
                    " ( 25, 'Clariana de Cardener'), " +
                    " ( 25, 'Cogul (El)'), " +
                    " ( 25, 'Coll de Nargó'), " +
                    " ( 25, 'Coma i la Pedra (La)'), " +
                    " ( 25, 'Conca de Dalt'), " +
                    " ( 25, 'Corbins'), " +
                    " ( 25, 'Cubells'), " +
                    " ( 25, 'Espluga Calba (L'')'), " +
                    " ( 25, 'Espot'), " +
                    " ( 25, 'Estamariu'), " +
                    " ( 25, 'Estaràs'), " +
                    " ( 25, 'Esterri d''Àneu'), " +
                    " ( 25, 'Esterri de Cardós'), " +
                    " ( 25, 'Farrera'), " +
                    " ( 25, 'Fígols i Alinyà'), " +
                    " ( 25, 'Floresta (La)'), " +
                    " ( 25, 'Fondarella'), " +
                    " ( 25, 'Foradada'), " +
                    " ( 25, 'Fuliola (La)'), " +
                    " ( 25, 'Fulleda'), " +
                    " ( 25, 'Gavet de la Conca'), " +
                    " ( 25, 'Gimenells i el Pla de la Font'), " +
                    " ( 25, 'Golmés'), " +
                    " ( 25, 'Gósol'), " +
                    " ( 25, 'Granadella (La)'), " +
                    " ( 25, 'Granja d''Escarp (La)'), " +
                    " ( 25, 'Granyanella'), " +
                    " ( 25, 'Granyena de les Garrigues'), " +
                    " ( 25, 'Granyena de Segarra'), " +
                    " ( 25, 'Guimerà'), " +
                    " ( 25, 'Guingueta d''Àneu (La)'), " +
                    " ( 25, 'Guissona'), " +
                    " ( 25, 'Guixers'), " +
                    " ( 25, 'Isona i Conca Dellà'), " +
                    " ( 25, 'Ivars de Noguera'), " +
                    " ( 25, 'Ivars d''Urgell'), " +
                    " ( 25, 'Ivorra'), " +
                    " ( 25, 'Josa i Tuixén'), " +
                    " ( 25, 'Juncosa'), " +
                    " ( 25, 'Juneda'), " +
                    " ( 25, 'Les'), " +
                    " ( 25, 'Linyola'), " +
                    " ( 25, 'Lladorre'), " +
                    " ( 25, 'Lladurs'), " +
                    " ( 25, 'Llardecans'), " +
                    " ( 25, 'Llavorsí'), " +
                    " ( 25, 'Lleida'), " +
                    " ( 25, 'Lles de Cerdanya'), " +
                    " ( 25, 'Llimiana'), " +
                    " ( 25, 'Llobera'), " +
                    " ( 25, 'Maials'), " +
                    " ( 25, 'Maldà'), " +
                    " ( 25, 'Massalcoreig'), " +
                    " ( 25, 'Massoteres'), " +
                    " ( 25, 'Menàrguens'), " +
                    " ( 25, 'Miralcamp'), " +
                    " ( 25, 'Mollerussa'), " +
                    " ( 25, 'Molsosa (La)'), " +
                    " ( 25, 'Montellà i Martinet'), " +
                    " ( 25, 'Montferrer i Castellbò'), " +
                    " ( 25, 'Montgai'), " +
                    " ( 25, 'Montoliu de Lleida'), " +
                    " ( 25, 'Montoliu de Segarra'), " +
                    " ( 25, 'Montornès de Segarra'), " +
                    " ( 25, 'Nalec'), " +
                    " ( 25, 'Naut Aran'), " +
                    " ( 25, 'Navès'), " +
                    " ( 25, 'Odèn'), " +
                    " ( 25, 'Oliana'), " +
                    " ( 25, 'Oliola'), " +
                    " ( 25, 'Olius'), " +
                    " ( 25, 'Oluges (Les)'), " +
                    " ( 25, 'Omellons (Els)'), " +
                    " ( 25, 'Omells de na Gaia (Els)'), " +
                    " ( 25, 'Organyà'), " +
                    " ( 25, 'Os de Balaguer'), " +
                    " ( 25, 'Ossó de Sió'), " +
                    " ( 25, 'Palau d''Anglesola (El)'), " +
                    " ( 25, 'Penelles'), " +
                    " ( 25, 'Peramola'), " +
                    " ( 25, 'Pinell de Solsonès'), " +
                    " ( 25, 'Pinós'), " +
                    " ( 25, 'Plans de Sió (Els)'), " +
                    " ( 25, 'Poal (El)'), " +
                    " ( 25, 'Pobla de Cérvoles (La)'), " +
                    " ( 25, 'Pobla de Segur (La)'), " +
                    " ( 25, 'Pont de Bar (El)'), " +
                    " ( 25, 'Pont de Suert (El)'), " +
                    " ( 25, 'Ponts'), " +
                    " ( 25, 'Portella (La)'), " +
                    " ( 25, 'Prats i Sansor'), " +
                    " ( 25, 'Preixana'), " +
                    " ( 25, 'Preixens'), " +
                    " ( 25, 'Prullans'), " +
                    " ( 25, 'Puiggròs'), " +
                    " ( 25, 'Puigverd d''Agramunt'), " +
                    " ( 25, 'Puigverd de Lleida'), " +
                    " ( 25, 'Rialp'), " +
                    " ( 25, 'Ribera d''Ondara'), " +
                    " ( 25, 'Ribera d''Urgellet'), " +
                    " ( 25, 'Riner'), " +
                    " ( 25, 'Riu de Cerdanya'), " +
                    " ( 25, 'Rosselló'), " +
                    " ( 25, 'Salàs de Pallars'), " +
                    " ( 25, 'Sanaüja'), " +
                    " ( 25, 'Sant Esteve de la Sarga'), " +
                    " ( 25, 'Sant Guim de Freixenet'), " +
                    " ( 25, 'Sant Guim de la Plana'), " +
                    " ( 25, 'Sant Llorenç de Morunys'), " +
                    " ( 25, 'Sant Martí de Riucorb'), " +
                    " ( 25, 'Sant Ramon'), " +
                    " ( 25, 'Sarroca de Bellera'), " +
                    " ( 25, 'Sarroca de Lleida'), " +
                    " ( 25, 'Senterada'), " +
                    " ( 25, 'Sentiu de Sió (La)'), " +
                    " ( 25, 'Seròs'), " +
                    " ( 25, 'Seu d''Urgell (La)'), " +
                    " ( 25, 'Sidamon'), " +
                    " ( 25, 'Soleràs (El)'); "); 
                    
                    stmt.executeUpdate("INSERT INTO `zk_poblacion` (`provincia`, `poblacion`) VALUES " +
                    " ( 25, 'Solsona'), " +
                    " ( 25, 'Soriguera'), " +
                    " ( 25, 'Sort'), " +
                    " ( 25, 'Soses'), " +
                    " ( 25, 'Sudanell'), " +
                    " ( 25, 'Sunyer'), " +
                    " ( 25, 'Talarn'), " +
                    " ( 25, 'Talavera'), " +
                    " ( 25, 'Tàrrega'), " +
                    " ( 25, 'Tarrés'), " +
                    " ( 25, 'Tarroja de Segarra'), " +
                    " ( 25, 'Térmens'), " +
                    " ( 25, 'Tírvia'), " +
                    " ( 25, 'Tiurana'), " +
                    " ( 25, 'Torà'), " +
                    " ( 25, 'Torms (Els)'), " +
                    " ( 25, 'Tornabous'), " +
                    " ( 25, 'Torre de Cabdella (La)'), " +
                    " ( 25, 'Torrebesses'), " +
                    " ( 25, 'Torrefarrera'), " +
                    " ( 25, 'Torrefeta i Florejacs'), " +
                    " ( 25, 'Torregrossa'), " +
                    " ( 25, 'Torrelameu'), " +
                    " ( 25, 'Torres de Segre'), " +
                    " ( 25, 'Torre-serona'), " +
                    " ( 25, 'Tremp'), " +
                    " ( 25, 'Vall de Boí (La)'), " +
                    " ( 25, 'Vall de Cardós'), " +
                    " ( 25, 'Vallbona de les Monges'), " +
                    " ( 25, 'Vallfogona de Balaguer'), " +
                    " ( 25, 'Valls d''Aguilar (Les)'), " +
                    " ( 25, 'Valls de Valira (Les)'), " +
                    " ( 25, 'Vansa i Fórnols (La)'), " +
                    " ( 25, 'Verdú'), " +
                    " ( 25, 'Vielha e Mijaran'), " +
                    " ( 25, 'Vilagrassa'), " +
                    " ( 25, 'Vilaller'), " +
                    " ( 25, 'Vilamòs'), " +
                    " ( 25, 'Vilanova de Bellpuig'), " +
                    " ( 25, 'Vilanova de la Barca'), " +
                    " ( 25, 'Vilanova de l''Aguda'), " +
                    " ( 25, 'Vilanova de Meià'), " +
                    " ( 25, 'Vilanova de Segrià'), " +
                    " ( 25, 'Vila-sana'), " +
                    " ( 25, 'Vilosell (El)'), " +
                    " ( 25, 'Vinaixa'), " +
                    " ( 26, 'Ábalos'), " +
                    " ( 26, 'Agoncillo'), " +
                    " ( 26, 'Aguilar del Río Alhama'), " +
                    " ( 26, 'Ajamil'), " +
                    " ( 26, 'Albelda de Iregua'), " +
                    " ( 26, 'Alberite'), " +
                    " ( 26, 'Alcanadre'), " +
                    " ( 26, 'Aldeanueva de Ebro'), " +
                    " ( 26, 'Alesanco'), " +
                    " ( 26, 'Alesón'), " +
                    " ( 26, 'Alfaro'), " +
                    " ( 26, 'Almarza de Cameros'), " +
                    " ( 26, 'Anguciana'), " +
                    " ( 26, 'Anguiano'), " +
                    " ( 26, 'Arenzana de Abajo'), " +
                    " ( 26, 'Arenzana de Arriba'), " +
                    " ( 26, 'Arnedillo'), " +
                    " ( 26, 'Arnedo'), " +
                    " ( 26, 'Arrúbal'), " +
                    " ( 26, 'Ausejo'), " +
                    " ( 26, 'Autol'), " +
                    " ( 26, 'Azofra'), " +
                    " ( 26, 'Badarán'), " +
                    " ( 26, 'Bañares'), " +
                    " ( 26, 'Baños de Río Tobía'), " +
                    " ( 26, 'Baños de Rioja'), " +
                    " ( 26, 'Berceo'), " +
                    " ( 26, 'Bergasa'), " +
                    " ( 26, 'Bergasillas Bajera'), " +
                    " ( 26, 'Bezares'), " +
                    " ( 26, 'Bobadilla'), " +
                    " ( 26, 'Brieva de Cameros'), " +
                    " ( 26, 'Briñas'), " +
                    " ( 26, 'Briones'), " +
                    " ( 26, 'Cabezón de Cameros'), " +
                    " ( 26, 'Calahorra'), " +
                    " ( 26, 'Camprovín'), " +
                    " ( 26, 'Canales de la Sierra'), " +
                    " ( 26, 'Canillas de Río Tuerto'), " +
                    " ( 26, 'Cañas'), " +
                    " ( 26, 'Cárdenas'), " +
                    " ( 26, 'Casalarreina'), " +
                    " ( 26, 'Castañares de Rioja'), " +
                    " ( 26, 'Castroviejo'), " +
                    " ( 26, 'Cellorigo'), " +
                    " ( 26, 'Cenicero'), " +
                    " ( 26, 'Cervera del Río Alhama'), " +
                    " ( 26, 'Cidamón'), " +
                    " ( 26, 'Cihuri'), " +
                    " ( 26, 'Cirueña'), " +
                    " ( 26, 'Clavijo'), " +
                    " ( 26, 'Cordovín'), " +
                    " ( 26, 'Corera'), " +
                    " ( 26, 'Cornago'), " +
                    " ( 26, 'Corporales'), " +
                    " ( 26, 'Cuzcurrita de Río Tirón'), " +
                    " ( 26, 'Daroca de Rioja'), " +
                    " ( 26, 'Enciso'), " +
                    " ( 26, 'Entrena'), " +
                    " ( 26, 'Estollo'), " +
                    " ( 26, 'Ezcaray'), " +
                    " ( 26, 'Foncea'), " +
                    " ( 26, 'Fonzaleche'), " +
                    " ( 26, 'Fuenmayor'), " +
                    " ( 26, 'Galbárruli'), " +
                    " ( 26, 'Galilea'), " +
                    " ( 26, 'Gallinero de Cameros'), " +
                    " ( 26, 'Gimileo'), " +
                    " ( 26, 'Grañón'), " +
                    " ( 26, 'Grávalos'), " +
                    " ( 26, 'Haro'), " +
                    " ( 26, 'Herce'), " +
                    " ( 26, 'Herramélluri'), " +
                    " ( 26, 'Hervías'), " +
                    " ( 26, 'Hormilla'), " +
                    " ( 26, 'Hormilleja'), " +
                    " ( 26, 'Hornillos de Cameros'), " +
                    " ( 26, 'Hornos de Moncalvillo'), " +
                    " ( 26, 'Huércanos'), " +
                    " ( 26, 'Igea'), " +
                    " ( 26, 'Jalón de Cameros'), " +
                    " ( 26, 'Laguna de Cameros'), " +
                    " ( 26, 'Lagunilla del Jubera'), " +
                    " ( 26, 'Lardero'), " +
                    " ( 26, 'Ledesma de la Cogolla'), " +
                    " ( 26, 'Leiva'), " +
                    " ( 26, 'Leza de Río Leza'), " +
                    " ( 26, 'Logroño'), " +
                    " ( 26, 'Lumbreras'), " +
                    " ( 26, 'Manjarrés'), " +
                    " ( 26, 'Mansilla de la Sierra'), " +
                    " ( 26, 'Manzanares de Rioja'), " +
                    " ( 26, 'Matute'), " +
                    " ( 26, 'Medrano'), " +
                    " ( 26, 'Munilla'), " +
                    " ( 26, 'Murillo de Río Leza'), " +
                    " ( 26, 'Muro de Aguas'), " +
                    " ( 26, 'Muro en Cameros'), " +
                    " ( 26, 'Nájera'), " +
                    " ( 26, 'Nalda'), " +
                    " ( 26, 'Navajún'), " +
                    " ( 26, 'Navarrete'), " +
                    " ( 26, 'Nestares'), " +
                    " ( 26, 'Nieva de Cameros'), " +
                    " ( 26, 'Ochánduri'), " +
                    " ( 26, 'Ocón'), " +
                    " ( 26, 'Ojacastro'), " +
                    " ( 26, 'Ollauri'), " +
                    " ( 26, 'Ortigosa de Cameros'), " +
                    " ( 26, 'Pazuengos'), " +
                    " ( 26, 'Pedroso'), " +
                    " ( 26, 'Pinillos'), " +
                    " ( 26, 'Pradejón'), " +
                    " ( 26, 'Pradillo'), " +
                    " ( 26, 'Préjano'), " +
                    " ( 26, 'Quel'), " +
                    " ( 26, 'Rabanera'), " +
                    " ( 26, 'Rasillo de Cameros (El)'), " +
                    " ( 26, 'Redal (El)'), " +
                    " ( 26, 'Ribafrecha'), " +
                    " ( 26, 'Rincón de Soto'), " +
                    " ( 26, 'Robres del Castillo'), " +
                    " ( 26, 'Rodezno'), " +
                    " ( 26, 'Sajazarra'), " +
                    " ( 26, 'San Asensio'), " +
                    " ( 26, 'San Millán de la Cogolla'), " +
                    " ( 26, 'San Millán de Yécora'), " +
                    " ( 26, 'San Román de Cameros'), " +
                    " ( 26, 'San Torcuato'), " +
                    " ( 26, 'San Vicente de la Sonsierra'), " +
                    " ( 26, 'Santa Coloma'), " +
                    " ( 26, 'Santa Engracia del Jubera'), " +
                    " ( 26, 'Santa Eulalia Bajera'), " +
                    " ( 26, 'Santo Domingo de la Calzada'), " +
                    " ( 26, 'Santurde de Rioja'), " +
                    " ( 26, 'Santurdejo'), " +
                    " ( 26, 'Sojuela'), " +
                    " ( 26, 'Sorzano'), " +
                    " ( 26, 'Sotés'), " +
                    " ( 26, 'Soto en Cameros'), " +
                    " ( 26, 'Terroba'), " +
                    " ( 26, 'Tirgo'), " +
                    " ( 26, 'Tobía'), " +
                    " ( 26, 'Tormantos'), " +
                    " ( 26, 'Torre en Cameros'), " +
                    " ( 26, 'Torrecilla en Cameros'), " +
                    " ( 26, 'Torrecilla sobre Alesanco'), " +
                    " ( 26, 'Torremontalbo'), " +
                    " ( 26, 'Treviana'), " +
                    " ( 26, 'Tricio'), " +
                    " ( 26, 'Tudelilla'), " +
                    " ( 26, 'Uruñuela'), " +
                    " ( 26, 'Valdemadera'), " +
                    " ( 26, 'Valgañón'), " +
                    " ( 26, 'Ventosa'), " +
                    " ( 26, 'Ventrosa'), " +
                    " ( 26, 'Viguera'), " +
                    " ( 26, 'Villalba de Rioja'), " +
                    " ( 26, 'Villalobar de Rioja'), " +
                    " ( 26, 'Villamediana de Iregua'), " +
                    " ( 26, 'Villanueva de Cameros'), " +
                    " ( 26, 'Villar de Arnedo (El)'), " +
                    " ( 26, 'Villar de Torre'), " +
                    " ( 26, 'Villarejo'), " +
                    " ( 26, 'Villarroya'), " +
                    " ( 26, 'Villarta-Quintana'), " +
                    " ( 26, 'Villavelayo'), " +
                    " ( 26, 'Villaverde de Rioja'), " +
                    " ( 26, 'Villoslada de Cameros'), " +
                    " ( 26, 'Viniegra de Abajo'), " +
                    " ( 26, 'Viniegra de Arriba'), " +
                    " ( 26, 'Zarratón'), " +
                    " ( 26, 'Zarzosa'), " +
                    " ( 26, 'Zorraquín'), " +
                    " ( 27, 'Abadín'), " +
                    " ( 27, 'Alfoz'), " +
                    " ( 27, 'Antas de Ulla'), " +
                    " ( 27, 'Baleira'), " +
                    " ( 27, 'Baralla'), " +
                    " ( 27, 'Barreiros'), " +
                    " ( 27, 'Becerreá'), " +
                    " ( 27, 'Begonte'), " +
                    " ( 27, 'Bóveda'), " +
                    " ( 27, 'Burela'), " +
                    " ( 27, 'Carballedo'), " +
                    " ( 27, 'Castro de Rei'), " +
                    " ( 27, 'Castroverde'), " +
                    " ( 27, 'Cervantes'), " +
                    " ( 27, 'Cervo'), " +
                    " ( 27, 'Chantada'), " +
                    " ( 27, 'Corgo (O)'), " +
                    " ( 27, 'Cospeito'), " +
                    " ( 27, 'Folgoso do Courel'), " +
                    " ( 27, 'Fonsagrada (A)'), " +
                    " ( 27, 'Foz'), " +
                    " ( 27, 'Friol'), " +
                    " ( 27, 'Guitiriz'), " +
                    " ( 27, 'Guntín'), " +
                    " ( 27, 'Incio (O)'), " +
                    " ( 27, 'Láncara'), " +
                    " ( 27, 'Lourenzá'), " +
                    " ( 27, 'Lugo'), " +
                    " ( 27, 'Meira'), " +
                    " ( 27, 'Mondoñedo'), " +
                    " ( 27, 'Monforte de Lemos'), " +
                    " ( 27, 'Monterroso'), " +
                    " ( 27, 'Muras'), " +
                    " ( 27, 'Navia de Suarna'), " +
                    " ( 27, 'Negueira de Muñiz'), " +
                    " ( 27, 'Nogais (As)'), " +
                    " ( 27, 'Ourol'), " +
                    " ( 27, 'Outeiro de Rei'), " +
                    " ( 27, 'Palas de Rei'), " +
                    " ( 27, 'Pantón'), " +
                    " ( 27, 'Paradela'), " +
                    " ( 27, 'Páramo (O)'), " +
                    " ( 27, 'Pastoriza (A)'), " +
                    " ( 27, 'Pedrafita do Cebreiro'), " +
                    " ( 27, 'Pobra do Brollón (A)'), " +
                    " ( 27, 'Pol'), " +
                    " ( 27, 'Pontenova (A)'), " +
                    " ( 27, 'Portomarín'), " +
                    " ( 27, 'Quiroga'), " +
                    " ( 27, 'Rábade'), " +
                    " ( 27, 'Ribadeo'), " +
                    " ( 27, 'Ribas de Sil'), " +
                    " ( 27, 'Ribeira de Piquín'), " +
                    " ( 27, 'Riotorto'), " +
                    " ( 27, 'Samos'), " +
                    " ( 27, 'Sarria'), " +
                    " ( 27, 'Saviñao (O)'), " +
                    " ( 27, 'Sober'), " +
                    " ( 27, 'Taboada'), " +
                    " ( 27, 'Trabada'), " +
                    " ( 27, 'Triacastela'), " +
                    " ( 27, 'Valadouro (O)'), " +
                    " ( 27, 'Vicedo (O)'), " +
                    " ( 27, 'Vilalba'), " +
                    " ( 27, 'Viveiro'), " +
                    " ( 27, 'Xermade'), " +
                    " ( 27, 'Xove'), " +
                    " ( 28, 'Acebeda (La)'), " +
                    " ( 28, 'Ajalvir'), " +
                    " ( 28, 'Alameda del Valle'), " +
                    " ( 28, 'Álamo (El)'), " +
                    " ( 28, 'Alcalá de Henares'), " +
                    " ( 28, 'Alcobendas'), " +
                    " ( 28, 'Alcorcón'), " +
                    " ( 28, 'Aldea del Fresno'), " +
                    " ( 28, 'Algete'), " +
                    " ( 28, 'Alpedrete'), " +
                    " ( 28, 'Ambite'), " +
                    " ( 28, 'Anchuelo'), " +
                    " ( 28, 'Aranjuez'), " +
                    " ( 28, 'Arganda del Rey'), " +
                    " ( 28, 'Arroyomolinos (Madrid)'), " +
                    " ( 28, 'Atazar (El)'), " +
                    " ( 28, 'Batres'), " +
                    " ( 28, 'Becerril de la Sierra'), " +
                    " ( 28, 'Belmonte de Tajo'), " +
                    " ( 28, 'Berrueco (El)'), " +
                    " ( 28, 'Berzosa del Lozoya'), " +
                    " ( 28, 'Boadilla del Monte'), " +
                    " ( 28, 'Boalo (El)'), " +
                    " ( 28, 'Braojos'), " +
                    " ( 28, 'Brea de Tajo'), " +
                    " ( 28, 'Brunete'), " +
                    " ( 28, 'Buitrago del Lozoya'), " +
                    " ( 28, 'Bustarviejo'), " +
                    " ( 28, 'Cabanillas de la Sierra'), " +
                    " ( 28, 'Cabrera (La)'), " +
                    " ( 28, 'Cadalso de los Vidrios'), " +
                    " ( 28, 'Camarma de Esteruelas'), " +
                    " ( 28, 'Campo Real'), " +
                    " ( 28, 'Canencia'), " +
                    " ( 28, 'Carabaña'), " +
                    " ( 28, 'Casarrubuelos'), " +
                    " ( 28, 'Cenicientos'), " +
                    " ( 28, 'Cercedilla'), " +
                    " ( 28, 'Cervera de Buitrago'), " +
                    " ( 28, 'Chapinería'), " +
                    " ( 28, 'Chinchón'), " +
                    " ( 28, 'Ciempozuelos'), " +
                    " ( 28, 'Cobeña'), " +
                    " ( 28, 'Collado Mediano'), " +
                    " ( 28, 'Collado Villalba'), " +
                    " ( 28, 'Colmenar de Oreja'), " +
                    " ( 28, 'Colmenar del Arroyo'), " +
                    " ( 28, 'Colmenar Viejo'), " +
                    " ( 28, 'Colmenarejo'), " +
                    " ( 28, 'Corpa'), " +
                    " ( 28, 'Coslada'), " +
                    " ( 28, 'Cubas de la Sagra'), " +
                    " ( 28, 'Daganzo de Arriba'), " +
                    " ( 28, 'Escorial (El)'), " +
                    " ( 28, 'Estremera'), " +
                    " ( 28, 'Fresnedillas de la Oliva'), " +
                    " ( 28, 'Fresno de Torote'), " +
                    " ( 28, 'Fuenlabrada'), " +
                    " ( 28, 'Fuente el Saz de Jarama'), " +
                    " ( 28, 'Fuentidueña de Tajo'), " +
                    " ( 28, 'Galapagar'), " +
                    " ( 28, 'Garganta de los Montes'), " +
                    " ( 28, 'Gargantilla del Lozoya y Pinilla de Buitrago'), " +
                    " ( 28, 'Gascones'), " +
                    " ( 28, 'Getafe'), " +
                    " ( 28, 'Griñón'), " +
                    " ( 28, 'Guadalix de la Sierra'), " +
                    " ( 28, 'Guadarrama'), " +
                    " ( 28, 'Hiruela (La)'), " +
                    " ( 28, 'Horcajo de la Sierra'), " +
                    " ( 28, 'Horcajuelo de la Sierra'), " +
                    " ( 28, 'Hoyo de Manzanares'), " +
                    " ( 28, 'Humanes de Madrid'), " +
                    " ( 28, 'Leganés'), " +
                    " ( 28, 'Loeches'), " +
                    " ( 28, 'Lozoya'), " +
                    " ( 28, 'Lozoyuela-Navas-Sieteiglesias'), " +
                    " ( 28, 'Madarcos'), " +
                    " ( 28, 'Madrid'), " +
                    " ( 28, 'Majadahonda'), " +
                    " ( 28, 'Manzanares el Real'), " +
                    " ( 28, 'Meco'), " +
                    " ( 28, 'Mejorada del Campo'), " +
                    " ( 28, 'Miraflores de la Sierra'), " +
                    " ( 28, 'Molar (El)'), " +
                    " ( 28, 'Molinos (Los)'), " +
                    " ( 28, 'Montejo de la Sierra'), " +
                    " ( 28, 'Moraleja de Enmedio'), " +
                    " ( 28, 'Moralzarzal'), " +
                    " ( 28, 'Morata de Tajuña'), " +
                    " ( 28, 'Móstoles'), " +
                    " ( 28, 'Navacerrada'), " +
                    " ( 28, 'Navalafuente'), " +
                    " ( 28, 'Navalagamella'), " +
                    " ( 28, 'Navalcarnero'), " +
                    " ( 28, 'Navarredonda y San Mamés'), " +
                    " ( 28, 'Navas del Rey'), " +
                    " ( 28, 'Nuevo Baztán'), " +
                    " ( 28, 'Olmeda de las Fuentes'), " +
                    " ( 28, 'Orusco de Tajuña'), " +
                    " ( 28, 'Paracuellos de Jarama'), " +
                    " ( 28, 'Parla'), " +
                    " ( 28, 'Patones'), " +
                    " ( 28, 'Pedrezuela'), " +
                    " ( 28, 'Pelayos de la Presa'), " +
                    " ( 28, 'Perales de Tajuña'), " +
                    " ( 28, 'Pezuela de las Torres'), " +
                    " ( 28, 'Pinilla del Valle'), " +
                    " ( 28, 'Pinto'), " +
                    " ( 28, 'Piñuécar-Gandullas'), " +
                    " ( 28, 'Pozuelo de Alarcón'), " +
                    " ( 28, 'Pozuelo del Rey'), " +
                    " ( 28, 'Prádena del Rincón'), " +
                    " ( 28, 'Puebla de la Sierra'), " +
                    " ( 28, 'Puentes Viejas'), " +
                    " ( 28, 'Quijorna'), " +
                    " ( 28, 'Rascafría'), " +
                    " ( 28, 'Redueña'), " +
                    " ( 28, 'Ribatejada'), " +
                    " ( 28, 'Rivas-Vaciamadrid'), " +
                    " ( 28, 'Robledillo de la Jara'), " +
                    " ( 28, 'Robledo de Chavela'), " +
                    " ( 28, 'Robregordo'), " +
                    " ( 28, 'Rozas de Madrid (Las)'), " +
                    " ( 28, 'Rozas de Puerto Real'), " +
                    " ( 28, 'San Agustín del Guadalix'), " +
                    " ( 28, 'San Fernando de Henares'), " +
                    " ( 28, 'San Lorenzo de El Escorial'), " +
                    " ( 28, 'San Martín de la Vega'), " +
                    " ( 28, 'San Martín de Valdeiglesias'), " +
                    " ( 28, 'San Sebastián de los Reyes'), " +
                    " ( 28, 'Santa María de la Alameda'), " +
                    " ( 28, 'Santorcaz'), " +
                    " ( 28, 'Santos de la Humosa (Los)'), " +
                    " ( 28, 'Serna del Monte (La)'), " +
                    " ( 28, 'Serranillos del Valle'), " +
                    " ( 28, 'Sevilla la Nueva'), " +
                    " ( 28, 'Somosierra'), " +
                    " ( 28, 'Soto del Real'), " +
                    " ( 28, 'Talamanca de Jarama'), " +
                    " ( 28, 'Tielmes'), " +
                    " ( 28, 'Titulcia'), " +
                    " ( 28, 'Torrejón de Ardoz'), " +
                    " ( 28, 'Torrejón de la Calzada'), " +
                    " ( 28, 'Torrejón de Velasco'), " +
                    " ( 28, 'Torrelaguna'), " +
                    " ( 28, 'Torrelodones'), " +
                    " ( 28, 'Torremocha de Jarama'), " +
                    " ( 28, 'Torres de la Alameda'), " +
                    " ( 28, 'Tres Cantos'), " +
                    " ( 28, 'Valdaracete'), " +
                    " ( 28, 'Valdeavero'), " +
                    " ( 28, 'Valdelaguna'), " +
                    " ( 28, 'Valdemanco'), " +
                    " ( 28, 'Valdemaqueda'), " +
                    " ( 28, 'Valdemorillo'), " +
                    " ( 28, 'Valdemoro'), " +
                    " ( 28, 'Valdeolmos-Alalpardo'), " +
                    " ( 28, 'Valdepiélagos'), " +
                    " ( 28, 'Valdetorres de Jarama'), " +
                    " ( 28, 'Valdilecha'), " +
                    " ( 28, 'Valverde de Alcalá'), " +
                    " ( 28, 'Velilla de San Antonio'), " +
                    " ( 28, 'Vellón (El)'), " +
                    " ( 28, 'Venturada'), " +
                    " ( 28, 'Villa del Prado'), " +
                    " ( 28, 'Villaconejos'), " +
                    " ( 28, 'Villalbilla'), " +
                    " ( 28, 'Villamanrique de Tajo'), " +
                    " ( 28, 'Villamanta'), " +
                    " ( 28, 'Villamantilla'), " +
                    " ( 28, 'Villanueva de la Cañada'), " +
                    " ( 28, 'Villanueva de Perales'), " +
                    " ( 28, 'Villanueva del Pardillo'), " +
                    " ( 28, 'Villar del Olmo'), " +
                    " ( 28, 'Villarejo de Salvanés'), " +
                    " ( 28, 'Villaviciosa de Odón'), " +
                    " ( 28, 'Villavieja del Lozoya'), " +
                    " ( 28, 'Zarzalejo'), " +
                    " ( 29, 'Alameda'), " +
                    " ( 29, 'Alcaucín'), " +
                    " ( 29, 'Alfarnate'), " +
                    " ( 29, 'Alfarnatejo'), " +
                    " ( 29, 'Algarrobo'), " +
                    " ( 29, 'Algatocín'), " +
                    " ( 29, 'Alhaurín de la Torre'), " +
                    " ( 29, 'Alhaurín el Grande'), " +
                    " ( 29, 'Almáchar'), " +
                    " ( 29, 'Almargen'), " +
                    " ( 29, 'Almogía'), " +
                    " ( 29, 'Álora'), " +
                    " ( 29, 'Alozaina'), " +
                    " ( 29, 'Alpandeire'), " +
                    " ( 29, 'Antequera'), " +
                    " ( 29, 'Árchez'), " +
                    " ( 29, 'Archidona'), " +
                    " ( 29, 'Ardales'), " +
                    " ( 29, 'Arenas'), " +
                    " ( 29, 'Arriate'), " +
                    " ( 29, 'Atajate'), " +
                    " ( 29, 'Benadalid'), " +
                    " ( 29, 'Benahavís'), " +
                    " ( 29, 'Benalauría'), " +
                    " ( 29, 'Benalmádena'), " +
                    " ( 29, 'Benamargosa'), " +
                    " ( 29, 'Benamocarra'), " +
                    " ( 29, 'Benaoján'), " +
                    " ( 29, 'Benarrabá'), " +
                    " ( 29, 'Borge (El)'), " +
                    " ( 29, 'Burgo (El)'), " +
                    " ( 29, 'Campillos'), " +
                    " ( 29, 'Canillas de Aceituno'), " +
                    " ( 29, 'Canillas de Albaida'), " +
                    " ( 29, 'Cañete la Real'), " +
                    " ( 29, 'Carratraca'), " +
                    " ( 29, 'Cartajima'), " +
                    " ( 29, 'Cártama'), " +
                    " ( 29, 'Casabermeja'), " +
                    " ( 29, 'Casarabonela'), " +
                    " ( 29, 'Casares'), " +
                    " ( 29, 'Coín'), " +
                    " ( 29, 'Colmenar'), " +
                    " ( 29, 'Comares'), " +
                    " ( 29, 'Cómpeta'), " +
                    " ( 29, 'Cortes de la Frontera'), " +
                    " ( 29, 'Cuevas Bajas'), " +
                    " ( 29, 'Cuevas de San Marcos'), " +
                    " ( 29, 'Cuevas del Becerro'), " +
                    " ( 29, 'Cútar'), " +
                    " ( 29, 'Estepona'), " +
                    " ( 29, 'Faraján'), " +
                    " ( 29, 'Frigiliana'), " +
                    " ( 29, 'Fuengirola'), " +
                    " ( 29, 'Fuente de Piedra'), " +
                    " ( 29, 'Gaucín'), " +
                    " ( 29, 'Genalguacil'), " +
                    " ( 29, 'Guaro'), " +
                    " ( 29, 'Humilladero'), " +
                    " ( 29, 'Igualeja'), " +
                    " ( 29, 'Istán'), " +
                    " ( 29, 'Iznate'), " +
                    " ( 29, 'Jimera de Líbar'), " +
                    " ( 29, 'Jubrique'), " +
                    " ( 29, 'Júzcar'), " +
                    " ( 29, 'Macharaviaya'), " +
                    " ( 29, 'Málaga'), " +
                    " ( 29, 'Manilva'), " +
                    " ( 29, 'Marbella'), " +
                    " ( 29, 'Mijas'), " +
                    " ( 29, 'Moclinejo'), " +
                    " ( 29, 'Mollina'), " +
                    " ( 29, 'Monda'), " +
                    " ( 29, 'Montejaque'), " +
                    " ( 29, 'Nerja'), " +
                    " ( 29, 'Ojén'), " +
                    " ( 29, 'Parauta'), " +
                    " ( 29, 'Periana'), " +
                    " ( 29, 'Pizarra'), " +
                    " ( 29, 'Pujerra'), " +
                    " ( 29, 'Rincón de la Victoria'), " +
                    " ( 29, 'Riogordo'), " +
                    " ( 29, 'Ronda'), " +
                    " ( 29, 'Salares'), " +
                    " ( 29, 'Sayalonga'), " +
                    " ( 29, 'Sedella'), " +
                    " ( 29, 'Sierra de Yeguas'), " +
                    " ( 29, 'Teba'), " +
                    " ( 29, 'Tolox'), " +
                    " ( 29, 'Torremolinos'), " +
                    " ( 29, 'Torrox'), " +
                    " ( 29, 'Totalán'), " +
                    " ( 29, 'Valle de Abdalajís'), " +
                    " ( 29, 'Vélez-Málaga'), " +
                    " ( 29, 'Villanueva de Algaidas'), " +
                    " ( 29, 'Villanueva de Tapia'), " +
                    " ( 29, 'Villanueva del Rosario'), " +
                    " ( 29, 'Villanueva del Trabuco'), " +
                    " ( 29, 'Viñuela'), " +
                    " ( 29, 'Yunquera'), " +
                    " ( 30, 'Abanilla'), " +
                    " ( 30, 'Abarán'), " +
                    " ( 30, 'Águilas'), " +
                    " ( 30, 'Albudeite'), " +
                    " ( 30, 'Alcantarilla'), " +
                    " ( 30, 'Alcázares (Los)'), " +
                    " ( 30, 'Aledo'), " +
                    " ( 30, 'Alguazas'), " +
                    " ( 30, 'Alhama de Murcia'), " +
                    " ( 30, 'Archena'), " +
                    " ( 30, 'Beniel'), " +
                    " ( 30, 'Blanca'), " +
                    " ( 30, 'Bullas'), " +
                    " ( 30, 'Calasparra'), " +
                    " ( 30, 'Campos del Río'), " +
                    " ( 30, 'Caravaca de la Cruz'), " +
                    " ( 30, 'Cartagena'), " +
                    " ( 30, 'Cehegín'), " +
                    " ( 30, 'Ceutí'), " +
                    " ( 30, 'Cieza'), " +
                    " ( 30, 'Fortuna'), " +
                    " ( 30, 'Fuente Álamo de Murcia'), " +
                    " ( 30, 'Jumilla'), " +
                    " ( 30, 'Librilla'), " +
                    " ( 30, 'Lorca'), " +
                    " ( 30, 'Lorquí'), " +
                    " ( 30, 'Mazarrón'), " +
                    " ( 30, 'Molina de Segura'), " +
                    " ( 30, 'Moratalla'), " +
                    " ( 30, 'Mula'), " +
                    " ( 30, 'Murcia'), " +
                    " ( 30, 'Ojós'), " +
                    " ( 30, 'Pliego'), " +
                    " ( 30, 'Puerto Lumbreras'), " +
                    " ( 30, 'Ricote'), " +
                    " ( 30, 'San Javier'), " +
                    " ( 30, 'San Pedro del Pinatar'), " +
                    " ( 30, 'Santomera'), " +
                    " ( 30, 'Torre-Pacheco'), " +
                    " ( 30, 'Torres de Cotillas (Las)'), " +
                    " ( 30, 'Totana'), " +
                    " ( 30, 'Ulea'), " +
                    " ( 30, 'Unión (La)'), " +
                    " ( 30, 'Villanueva del Río Segura'), " +
                    " ( 30, 'Yecla'), " +
                    " ( 31, 'Abáigar'), " +
                    " ( 31, 'Abárzuza'), " +
                    " ( 31, 'Abaurregaina/Abaurrea Alta'), " +
                    " ( 31, 'Abaurrepea/Abaurrea Baja'), " +
                    " ( 31, 'Aberin'), " +
                    " ( 31, 'Ablitas'), " +
                    " ( 31, 'Adiós'), " +
                    " ( 31, 'Aguilar de Codés'), " +
                    " ( 31, 'Aibar/Oibar'), " +
                    " ( 31, 'Allín'), " +
                    " ( 31, 'Allo'), " +
                    " ( 31, 'Altsasu/Alsasua'), " +
                    " ( 31, 'Améscoa Baja'), " +
                    " ( 31, 'Ancín'), " +
                    " ( 31, 'Andosilla'), " +
                    " ( 31, 'Ansoáin'), " +
                    " ( 31, 'Anue'), " +
                    " ( 31, 'Añorbe'), " +
                    " ( 31, 'Aoiz/Agoitz'), " +
                    " ( 31, 'Araitz'), " +
                    " ( 31, 'Arakil'), " +
                    " ( 31, 'Aranarache'), " +
                    " ( 31, 'Aranguren'), " +
                    " ( 31, 'Arano'), " +
                    " ( 31, 'Arantza'), " +
                    " ( 31, 'Aras'), " +
                    " ( 31, 'Arbizu'), " +
                    " ( 31, 'Arce/Artzi'), " +
                    " ( 31, 'Arcos (Los)'), " +
                    " ( 31, 'Arellano'), " +
                    " ( 31, 'Areso'), " +
                    " ( 31, 'Arguedas'), " +
                    " ( 31, 'Aria'), " +
                    " ( 31, 'Aribe'), " +
                    " ( 31, 'Armañanzas'), " +
                    " ( 31, 'Arróniz'), " +
                    " ( 31, 'Arruazu'), " +
                    " ( 31, 'Artajona'), " +
                    " ( 31, 'Artazu'), " +
                    " ( 31, 'Atez'), " +
                    " ( 31, 'Auritz/Burguete'), " +
                    " ( 31, 'Ayegui'), " +
                    " ( 31, 'Azagra'), " +
                    " ( 31, 'Azuelo'), " +
                    " ( 31, 'Bakaiku'), " +
                    " ( 31, 'Barañain'), " +
                    " ( 31, 'Barásoain'), " +
                    " ( 31, 'Barbarin'), " +
                    " ( 31, 'Bargota'), " +
                    " ( 31, 'Barillas'), " +
                    " ( 31, 'Basaburua'), " +
                    " ( 31, 'Baztan'), " +
                    " ( 31, 'Beintza-Labaien'), " +
                    " ( 31, 'Beire'), " +
                    " ( 31, 'Belascoáin'), " +
                    " ( 31, 'Bera/Vera de Bidasoa'), " +
                    " ( 31, 'Berbinzana'), " +
                    " ( 31, 'Beriáin'), " +
                    " ( 31, 'Berrioplano'), " +
                    " ( 31, 'Berriozar'), " +
                    " ( 31, 'Bertizarana'), " +
                    " ( 31, 'Betelu'), " +
                    " ( 31, 'Bidaurreta'), " +
                    " ( 31, 'Biurrun-Olcoz'), " +
                    " ( 31, 'Buñuel'), " +
                    " ( 31, 'Burgui/Burgi'), " +
                    " ( 31, 'Burlada/Burlata'), " +
                    " ( 31, 'Busto (El)'), " +
                    " ( 31, 'Cabanillas'), " +
                    " ( 31, 'Cabredo'), " +
                    " ( 31, 'Cadreita'), " +
                    " ( 31, 'Caparroso'), " +
                    " ( 31, 'Cárcar'), " +
                    " ( 31, 'Carcastillo'), " +
                    " ( 31, 'Cascante'), " +
                    " ( 31, 'Cáseda'), " +
                    " ( 31, 'Castejón (Navarra)'), " +
                    " ( 31, 'Castillonuevo'), " +
                    " ( 31, 'Cendea de Olza/Oltza Zendea'), " +
                    " ( 31, 'Cintruénigo'), " +
                    " ( 31, 'Cirauqui'), " +
                    " ( 31, 'Ciriza'), " +
                    " ( 31, 'Cizur'), " +
                    " ( 31, 'Corella'), " +
                    " ( 31, 'Cortes'), " +
                    " ( 31, 'Desojo'), " +
                    " ( 31, 'Dicastillo'), " +
                    " ( 31, 'Donamaria'), " +
                    " ( 31, 'Doneztebe/Santesteban'), " +
                    " ( 31, 'Echarri'), " +
                    " ( 31, 'Egüés'), " +
                    " ( 31, 'Elgorriaga'), " +
                    " ( 31, 'Enériz'), " +
                    " ( 31, 'Eratsun'), " +
                    " ( 31, 'Ergoiena'), " +
                    " ( 31, 'Erro'), " +
                    " ( 31, 'Eslava'), " +
                    " ( 31, 'Esparza de Salazar/Espartza Zaraitzu'), " +
                    " ( 31, 'Espronceda'), " +
                    " ( 31, 'Estella/Lizarra'), " +
                    " ( 31, 'Esteribar'), " +
                    " ( 31, 'Etayo'), " +
                    " ( 31, 'Etxalar'), " +
                    " ( 31, 'Etxarri-Aranatz'), " +
                    " ( 31, 'Etxauri'), " +
                    " ( 31, 'Eulate'), " +
                    " ( 31, 'Ezcabarte'), " +
                    " ( 31, 'Ezcároz/Ezkaroze'), " +
                    " ( 31, 'Ezkurra'), " +
                    " ( 31, 'Ezprogui'), " +
                    " ( 31, 'Falces'), " +
                    " ( 31, 'Fitero'), " +
                    " ( 31, 'Fontellas'), " +
                    " ( 31, 'Funes'), " +
                    " ( 31, 'Fustiñana'), " +
                    " ( 31, 'Galar'), " +
                    " ( 31, 'Gallipienzo'), " +
                    " ( 31, 'Gallués/Galoze'), " +
                    " ( 31, 'Garaioa'), " +
                    " ( 31, 'Garde'), " +
                    " ( 31, 'Garínoain'), " +
                    " ( 31, 'Garralda'), " +
                    " ( 31, 'Genevilla'), " +
                    " ( 31, 'Goizueta'), " +
                    " ( 31, 'Goñi'), " +
                    " ( 31, 'Güesa/Gorza'), " +
                    " ( 31, 'Guesálaz'), " +
                    " ( 31, 'Guirguillano'), " +
                    " ( 31, 'Hiriberri/Villanueva de Aezkoa'), " +
                    " ( 31, 'Huarte/Uharte'), " +
                    " ( 31, 'Ibargoiti'), " +
                    " ( 31, 'Igantzi'), " +
                    " ( 31, 'Igúzquiza'), " +
                    " ( 31, 'Imotz'), " +
                    " ( 31, 'Irañeta'), " +
                    " ( 31, 'Irurtzun'), " +
                    " ( 31, 'Isaba/Izaba'), " +
                    " ( 31, 'Ituren'), " +
                    " ( 31, 'Iturmendi'), " +
                    " ( 31, 'Iza'), " +
                    " ( 31, 'Izagaondoa'), " +
                    " ( 31, 'Izalzu/Itzaltzu'), " +
                    " ( 31, 'Jaurrieta'), " +
                    " ( 31, 'Javier'), " +
                    " ( 31, 'Juslapeña'), " +
                    " ( 31, 'Lakuntza'), " +
                    " ( 31, 'Lana'), " +
                    " ( 31, 'Lantz'), " +
                    " ( 31, 'Lapoblación'), " +
                    " ( 31, 'Larraga'), " +
                    " ( 31, 'Larraona'), " +
                    " ( 31, 'Larraun'), " +
                    " ( 31, 'Lazagurría'), " +
                    " ( 31, 'Leache'), " +
                    " ( 31, 'Legarda'), " +
                    " ( 31, 'Legaria'), " +
                    " ( 31, 'Leitza'), " +
                    " ( 31, 'Lekunberri'), " +
                    " ( 31, 'Leoz'), " +
                    " ( 31, 'Lerga'), " +
                    " ( 31, 'Lerín'), " +
                    " ( 31, 'Lesaka'), " +
                    " ( 31, 'Lezáun'), " +
                    " ( 31, 'Liédena'), " +
                    " ( 31, 'Lizoáin'), " +
                    " ( 31, 'Lodosa'), " +
                    " ( 31, 'Lónguida/Longida'), " +
                    " ( 31, 'Lumbier'), " +
                    " ( 31, 'Luquin'), " +
                    " ( 31, 'Luzaide/Valcarlos'), " +
                    " ( 31, 'Mañeru'), " +
                    " ( 31, 'Marañón'), " +
                    " ( 31, 'Marcilla'), " +
                    " ( 31, 'Mélida'), " +
                    " ( 31, 'Mendavia'), " +
                    " ( 31, 'Mendaza'), " +
                    " ( 31, 'Mendigorría'), " +
                    " ( 31, 'Metauten'), " +
                    " ( 31, 'Milagro'), " +
                    " ( 31, 'Mirafuentes'), " +
                    " ( 31, 'Miranda de Arga'), " +
                    " ( 31, 'Monreal'), " +
                    " ( 31, 'Monteagudo'), " +
                    " ( 31, 'Morentin'), " +
                    " ( 31, 'Mues'), " +
                    " ( 31, 'Murchante'), " +
                    " ( 31, 'Murieta'), " +
                    " ( 31, 'Murillo el Cuende'), " +
                    " ( 31, 'Murillo el Fruto'), " +
                    " ( 31, 'Muruzábal'), " +
                    " ( 31, 'Navascués'), " +
                    " ( 31, 'Nazar'), " +
                    " ( 31, 'Noáin (Valle de Elorz)/Noain (Elortzibar)'), " +
                    " ( 31, 'Obanos'), " +
                    " ( 31, 'Ochagavía/Otsagabia'), " +
                    " ( 31, 'Oco'), " +
                    " ( 31, 'Odieta'), " +
                    " ( 31, 'Oitz'), " +
                    " ( 31, 'Olaibar'), " +
                    " ( 31, 'Olazti/Olazagutía'), " +
                    " ( 31, 'Olejua'), " +
                    " ( 31, 'Olite'), " +
                    " ( 31, 'Ollo'), " +
                    " ( 31, 'Olóriz'), " +
                    " ( 31, 'Orbaitzeta'), " +
                    " ( 31, 'Orbara'), " +
                    " ( 31, 'Orísoain'), " +
                    " ( 31, 'Orkoien'), " +
                    " ( 31, 'Oronz/Orontze'), " +
                    " ( 31, 'Oroz-Betelu'), " +
                    " ( 31, 'Orreaga/Roncesvalles'), " +
                    " ( 31, 'Oteiza'), " +
                    " ( 31, 'Pamplona/Iruña'), " +
                    " ( 31, 'Peralta'), " +
                    " ( 31, 'Petilla de Aragón'), " +
                    " ( 31, 'Piedramillera'), " +
                    " ( 31, 'Pitillas'), " +
                    " ( 31, 'Puente la Reina/Gares'), " +
                    " ( 31, 'Pueyo'), " +
                    " ( 31, 'Ribaforada'), " +
                    " ( 31, 'Romanzado'), " +
                    " ( 31, 'Roncal/Erronkari'), " +
                    " ( 31, 'Sada (Navarra)'), " +
                    " ( 31, 'Saldías'), " +
                    " ( 31, 'Salinas de Oro'), " +
                    " ( 31, 'San Adrián'), " +
                    " ( 31, 'San Martín de Unx'), " +
                    " ( 31, 'Sangüesa/Zangoza'), " +
                    " ( 31, 'Sansol'), " +
                    " ( 31, 'Santacara'), " +
                    " ( 31, 'Sarriés/Sartze'), " +
                    " ( 31, 'Sartaguda'), " +
                    " ( 31, 'Sesma'), " +
                    " ( 31, 'Sorlada'), " +
                    " ( 31, 'Sunbilla'), " +
                    " ( 31, 'Tafalla'), " +
                    " ( 31, 'Tiebas-Muruarte de Reta'), " +
                    " ( 31, 'Tirapu'), " +
                    " ( 31, 'Torralba del Río'), " +
                    " ( 31, 'Torres del Río'), " +
                    " ( 31, 'Tudela'), " +
                    " ( 31, 'Tulebras'), " +
                    " ( 31, 'Ucar'), " +
                    " ( 31, 'Uharte-Arakil'), " +
                    " ( 31, 'Ujué'), " +
                    " ( 31, 'Ultzama'), " +
                    " ( 31, 'Unciti'), " +
                    " ( 31, 'Unzué'), " +
                    " ( 31, 'Urdazubi/Urdax'), " +
                    " ( 31, 'Urdiain'), " +
                    " ( 31, 'Urraul Alto'), " +
                    " ( 31, 'Urraul Bajo'), " +
                    " ( 31, 'Urrotz'), " +
                    " ( 31, 'Urroz-Villa'), " +
                    " ( 31, 'Urzainqui/Urzainki'), " +
                    " ( 31, 'Uterga'), " +
                    " ( 31, 'Uztárroz/Uztarroze'), " +
                    " ( 31, 'Valle de Yerri/Deierri'), " +
                    " ( 31, 'Valtierra'), " +
                    " ( 31, 'Viana'), " +
                    " ( 31, 'Vidángoz/Bidankoze'), " +
                    " ( 31, 'Villafranca'), " +
                    " ( 31, 'Villamayor de Monjardín'), " +
                    " ( 31, 'Villatuerta'), " +
                    " ( 31, 'Villava/Atarrabia'), " +
                    " ( 31, 'Yesa'), " +
                    " ( 31, 'Zabalza'), " +
                    " ( 31, 'Ziordia'), " +
                    " ( 31, 'Zizur Mayor/Zizur Nagusia'), " +
                    " ( 31, 'Zubieta'), " +
                    " ( 31, 'Zugarramurdi'), " +
                    " ( 31, 'Zúñiga'), " +
                    " ( 32, 'Allariz'), " +
                    " ( 32, 'Amoeiro'), " +
                    " ( 32, 'Arnoia (A)'), " +
                    " ( 32, 'Avión'), " +
                    " ( 32, 'Baltar'), " +
                    " ( 32, 'Bande'), " +
                    " ( 32, 'Baños de Molgas'), " +
                    " ( 32, 'Barbadás'), " +
                    " ( 32, 'Barco de Valdeorras (O)'), " +
                    " ( 32, 'Beade'), " +
                    " ( 32, 'Beariz'), " +
                    " ( 32, 'Blancos (Os)'), " +
                    " ( 32, 'Boborás'), " +
                    " ( 32, 'Bola (A)'), " +
                    " ( 32, 'Bolo (O)'), " +
                    " ( 32, 'Calvos de Randín'), " +
                    " ( 32, 'Carballeda de Avia'), " +
                    " ( 32, 'Carballeda de Valdeorras'), " +
                    " ( 32, 'Carballiño (O)'), " +
                    " ( 32, 'Cartelle'), " +
                    " ( 32, 'Castrelo de Miño'), " +
                    " ( 32, 'Castrelo do Val'), " +
                    " ( 32, 'Castro Caldelas'), " +
                    " ( 32, 'Celanova'), " +
                    " ( 32, 'Cenlle'), " +
                    " ( 32, 'Chandrexa de Queixa'), " +
                    " ( 32, 'Coles'), " +
                    " ( 32, 'Cortegada'), " +
                    " ( 32, 'Cualedro'), " +
                    " ( 32, 'Entrimo'), " +
                    " ( 32, 'Esgos'), " +
                    " ( 32, 'Gomesende'), " +
                    " ( 32, 'Gudiña (A)'), " +
                    " ( 32, 'Irixo (O)'), " +
                    " ( 32, 'Larouco'), " +
                    " ( 32, 'Laza'), " +
                    " ( 32, 'Leiro'), " +
                    " ( 32, 'Lobeira'), " +
                    " ( 32, 'Lobios'), " +
                    " ( 32, 'Maceda'), " +
                    " ( 32, 'Manzaneda'), " +
                    " ( 32, 'Maside'), " +
                    " ( 32, 'Melón'), " +
                    " ( 32, 'Merca (A)'), " +
                    " ( 32, 'Mezquita (A)'), " +
                    " ( 32, 'Montederramo'), " +
                    " ( 32, 'Monterrei'), " +
                    " ( 32, 'Muíños'), " +
                    " ( 32, 'Nogueira de Ramuín'), " +
                    " ( 32, 'Oímbra'), " +
                    " ( 32, 'Ourense'), " +
                    " ( 32, 'Paderne de Allariz'), " +
                    " ( 32, 'Padrenda'), " +
                    " ( 32, 'Parada de Sil'), " +
                    " ( 32, 'Pereiro de Aguiar (O)'), " +
                    " ( 32, 'Peroxa (A)'), " +
                    " ( 32, 'Petín'), " +
                    " ( 32, 'Piñor'), " +
                    " ( 32, 'Pobra de Trives (A)'), " +
                    " ( 32, 'Pontedeva'), " +
                    " ( 32, 'Porqueira'), " +
                    " ( 32, 'Punxín'), " +
                    " ( 32, 'Quintela de Leirado'), " +
                    " ( 32, 'Rairiz de Veiga'), " +
                    " ( 32, 'Ramirás'), " +
                    " ( 32, 'Ribadavia'), " +
                    " ( 32, 'Riós'), " +
                    " ( 32, 'Rúa (A)'), " +
                    " ( 32, 'Rubiá'), " +
                    " ( 32, 'San Amaro'), " +
                    " ( 32, 'San Cibrao das Viñas'), " +
                    " ( 32, 'San Cristovo de Cea'), " +
                    " ( 32, 'San Xoán de Río'), " +
                    " ( 32, 'Sandiás'), " +
                    " ( 32, 'Sarreaus'), " +
                    " ( 32, 'Taboadela'), " +
                    " ( 32, 'Teixeira (A)'), " +
                    " ( 32, 'Toén'), " +
                    " ( 32, 'Trasmiras'), " +
                    " ( 32, 'Veiga (A)'), " +
                    " ( 32, 'Verea'), " +
                    " ( 32, 'Verín'), " +
                    " ( 32, 'Viana do Bolo'), " +
                    " ( 32, 'Vilamarín'), " +
                    " ( 32, 'Vilamartín de Valdeorras'), " +
                    " ( 32, 'Vilar de Barrio'), " +
                    " ( 32, 'Vilar de Santos'), " +
                    " ( 32, 'Vilardevós'), " +
                    " ( 32, 'Vilariño de Conso'), " +
                    " ( 32, 'Xinzo de Limia'), " +
                    " ( 32, 'Xunqueira de Ambía'), " +
                    " ( 32, 'Xunqueira de Espadanedo'), " +
                    " ( 33, 'Allande'), " +
                    " ( 33, 'Aller'), " +
                    " ( 33, 'Amieva'), " +
                    " ( 33, 'Avilés'), " +
                    " ( 33, 'Belmonte de Miranda'), " +
                    " ( 33, 'Bimenes'), " +
                    " ( 33, 'Boal'), " +
                    " ( 33, 'Cabrales'), " +
                    " ( 33, 'Cabranes'), " +
                    " ( 33, 'Candamo'), " +
                    " ( 33, 'Cangas de Onís'), " +
                    " ( 33, 'Cangas del Narcea'), " +
                    " ( 33, 'Caravia'), " +
                    " ( 33, 'Carreño'), " +
                    " ( 33, 'Caso'), " +
                    " ( 33, 'Castrillón'), " +
                    " ( 33, 'Castropol'), " +
                    " ( 33, 'Coaña'), " +
                    " ( 33, 'Colunga'), " +
                    " ( 33, 'Corvera de Asturias'), " +
                    " ( 33, 'Cudillero'), " +
                    " ( 33, 'Degaña'), " +
                    " ( 33, 'Franco (El)'), " +
                    " ( 33, 'Gijón'), " +
                    " ( 33, 'Gozón'), " +
                    " ( 33, 'Grado'), " +
                    " ( 33, 'Grandas de Salime'), " +
                    " ( 33, 'Ibias'), " +
                    " ( 33, 'Illano'), " +
                    " ( 33, 'Illas'), " +
                    " ( 33, 'Langreo'), " +
                    " ( 33, 'Laviana'), " +
                    " ( 33, 'Lena'), " +
                    " ( 33, 'Llanera'), " +
                    " ( 33, 'Llanes'), " +
                    " ( 33, 'Mieres (Asturias)'), " +
                    " ( 33, 'Morcín'), " +
                    " ( 33, 'Muros de Nalón'), " +
                    " ( 33, 'Nava'), " +
                    " ( 33, 'Navia'), " +
                    " ( 33, 'Noreña'), " +
                    " ( 33, 'Onís'), " +
                    " ( 33, 'Oviedo'), " +
                    " ( 33, 'Parres'), " +
                    " ( 33, 'Peñamellera Alta'), " +
                    " ( 33, 'Peñamellera Baja'), " +
                    " ( 33, 'Pesoz'), " +
                    " ( 33, 'Piloña'), " +
                    " ( 33, 'Ponga'), " +
                    " ( 33, 'Pravia'), " +
                    " ( 33, 'Proaza'), " +
                    " ( 33, 'Quirós'), " +
                    " ( 33, 'Regueras (Las)'), " +
                    " ( 33, 'Ribadedeva'), " +
                    " ( 33, 'Ribadesella'), " +
                    " ( 33, 'Ribera de Arriba'), " +
                    " ( 33, 'Riosa'), " +
                    " ( 33, 'Salas'), " +
                    " ( 33, 'San Martín de Oscos'), " +
                    " ( 33, 'San Martín del Rey Aurelio'), " +
                    " ( 33, 'San Tirso de Abres'), " +
                    " ( 33, 'Santa Eulalia de Oscos'), " +
                    " ( 33, 'Santo Adriano'), " +
                    " ( 33, 'Sariego'), " +
                    " ( 33, 'Siero'), " +
                    " ( 33, 'Sobrescobio'), " +
                    " ( 33, 'Somiedo'), " +
                    " ( 33, 'Soto del Barco'), " +
                    " ( 33, 'Tapia de Casariego'), " +
                    " ( 33, 'Taramundi'), " +
                    " ( 33, 'Teverga'), " +
                    " ( 33, 'Tineo'), " +
                    " ( 33, 'Valdés'), " +
                    " ( 33, 'Vegadeo'), " +
                    " ( 33, 'Villanueva de Oscos'), " +
                    " ( 33, 'Villaviciosa'), " +
                    " ( 33, 'Villayón'), " +
                    " ( 33, 'Yernes y Tameza'), " +
                    " ( 34, 'Abarca de Campos'), " +
                    " ( 34, 'Abia de las Torres'), " +
                    " ( 34, 'Aguilar de Campoo'), " +
                    " ( 34, 'Alar del Rey'), " +
                    " ( 34, 'Alba de Cerrato'), " +
                    " ( 34, 'Amayuelas de Arriba'), " +
                    " ( 34, 'Ampudia'), " +
                    " ( 34, 'Amusco'), " +
                    " ( 34, 'Antigüedad'), " +
                    " ( 34, 'Arconada'), " +
                    " ( 34, 'Astudillo'), " +
                    " ( 34, 'Autilla del Pino'), " +
                    " ( 34, 'Autillo de Campos'), " +
                    " ( 34, 'Ayuela'), " +
                    " ( 34, 'Baltanás'), " +
                    " ( 34, 'Baquerín de Campos'), " +
                    " ( 34, 'Bárcena de Campos'), " +
                    " ( 34, 'Barruelo de Santullán'), " +
                    " ( 34, 'Báscones de Ojeda'), " +
                    " ( 34, 'Becerril de Campos'), " +
                    " ( 34, 'Belmonte de Campos'), " +
                    " ( 34, 'Berzosilla'), " +
                    " ( 34, 'Boada de Campos'), " +
                    " ( 34, 'Boadilla de Rioseco'), " +
                    " ( 34, 'Boadilla del Camino'), " +
                    " ( 34, 'Brañosera'), " +
                    " ( 34, 'Buenavista de Valdavia'), " +
                    " ( 34, 'Bustillo de la Vega'), " +
                    " ( 34, 'Bustillo del Páramo de Carrión'), " +
                    " ( 34, 'Calahorra de Boedo'), " +
                    " ( 34, 'Calzada de los Molinos'), " +
                    " ( 34, 'Capillas'), " +
                    " ( 34, 'Cardeñosa de Volpejera'), " +
                    " ( 34, 'Carrión de los Condes'), " +
                    " ( 34, 'Castil de Vela'), " +
                    " ( 34, 'Castrejón de la Peña'), " +
                    " ( 34, 'Castrillo de Don Juan'), " +
                    " ( 34, 'Castrillo de Onielo'), " +
                    " ( 34, 'Castrillo de Villavega'), " +
                    " ( 34, 'Castromocho'), " +
                    " ( 34, 'Cervatos de la Cueza'), " +
                    " ( 34, 'Cervera de Pisuerga'), " +
                    " ( 34, 'Cevico de la Torre'), " +
                    " ( 34, 'Cevico Navero'), " +
                    " ( 34, 'Cisneros'), " +
                    " ( 34, 'Cobos de Cerrato'), " +
                    " ( 34, 'Collazos de Boedo'), " +
                    " ( 34, 'Congosto de Valdavia'), " +
                    " ( 34, 'Cordovilla la Real'), " +
                    " ( 34, 'Cubillas de Cerrato'), " +
                    " ( 34, 'Dehesa de Montejo'), " +
                    " ( 34, 'Dehesa de Romanos'), " +
                    " ( 34, 'Dueñas'), " +
                    " ( 34, 'Espinosa de Cerrato'), " +
                    " ( 34, 'Espinosa de Villagonzalo'), " +
                    " ( 34, 'Frechilla'), " +
                    " ( 34, 'Fresno del Río'), " +
                    " ( 34, 'Frómista'), " +
                    " ( 34, 'Fuentes de Nava'), " +
                    " ( 34, 'Fuentes de Valdepero'), " +
                    " ( 34, 'Grijota'), " +
                    " ( 34, 'Guardo'), " +
                    " ( 34, 'Guaza de Campos'), " +
                    " ( 34, 'Hérmedes de Cerrato'), " +
                    " ( 34, 'Herrera de Pisuerga'), " +
                    " ( 34, 'Herrera de Valdecañas'), " +
                    " ( 34, 'Hontoria de Cerrato'), " +
                    " ( 34, 'Hornillos de Cerrato'), " +
                    " ( 34, 'Husillos'), " +
                    " ( 34, 'Itero de la Vega'), " +
                    " ( 34, 'Lagartos'), " +
                    " ( 34, 'Lantadilla'), " +
                    " ( 34, 'Ledigos'), " +
                    " ( 34, 'Loma de Ucieza'), " +
                    " ( 34, 'Lomas'), " +
                    " ( 34, 'Magaz de Pisuerga'), " +
                    " ( 34, 'Manquillos'), " +
                    " ( 34, 'Mantinos'), " +
                    " ( 34, 'Marcilla de Campos'), " +
                    " ( 34, 'Mazariegos'), " +
                    " ( 34, 'Mazuecos de Valdeginate'), " +
                    " ( 34, 'Melgar de Yuso'), " +
                    " ( 34, 'Meneses de Campos'), " +
                    " ( 34, 'Micieces de Ojeda'), " +
                    " ( 34, 'Monzón de Campos'), " +
                    " ( 34, 'Moratinos'), " +
                    " ( 34, 'Mudá'), " +
                    " ( 34, 'Nogal de las Huertas'), " +
                    " ( 34, 'Olea de Boedo'), " +
                    " ( 34, 'Olmos de Ojeda'), " +
                    " ( 34, 'Osornillo'), " +
                    " ( 34, 'Osorno la Mayor'), " +
                    " ( 34, 'Palencia'), " +
                    " ( 34, 'Palenzuela'), " +
                    " ( 34, 'Páramo de Boedo'), " +
                    " ( 34, 'Paredes de Nava'), " +
                    " ( 34, 'Payo de Ojeda'), " +
                    " ( 34, 'Pedraza de Campos'), " +
                    " ( 34, 'Pedrosa de la Vega'), " +
                    " ( 34, 'Perales'), " +
                    " ( 34, 'Pernía (La)'), " +
                    " ( 34, 'Pino del Río'), " +
                    " ( 34, 'Piña de Campos'), " +
                    " ( 34, 'Población de Arroyo'), " +
                    " ( 34, 'Población de Campos'), " +
                    " ( 34, 'Población de Cerrato'), " +
                    " ( 34, 'Polentinos'), " +
                    " ( 34, 'Pomar de Valdivia'), " +
                    " ( 34, 'Poza de la Vega'), " +
                    " ( 34, 'Pozo de Urama'), " +
                    " ( 34, 'Prádanos de Ojeda'), " +
                    " ( 34, 'Puebla de Valdavia (La)'), " +
                    " ( 34, 'Quintana del Puente'), " +
                    " ( 34, 'Quintanilla de Onsoña'), " +
                    " ( 34, 'Reinoso de Cerrato'), " +
                    " ( 34, 'Renedo de la Vega'), " +
                    " ( 34, 'Requena de Campos'), " +
                    " ( 34, 'Respenda de la Peña'), " +
                    " ( 34, 'Revenga de Campos'), " +
                    " ( 34, 'Revilla de Collazos'), " +
                    " ( 34, 'Ribas de Campos'), " +
                    " ( 34, 'Riberos de la Cueza'), " +
                    " ( 34, 'Saldaña'), " +
                    " ( 34, 'Salinas de Pisuerga'), " +
                    " ( 34, 'San Cebrián de Campos'), " +
                    " ( 34, 'San Cebrián de Mudá'), " +
                    " ( 34, 'San Cristóbal de Boedo'), " +
                    " ( 34, 'San Mamés de Campos'), " +
                    " ( 34, 'San Román de la Cuba'), " +
                    " ( 34, 'Santa Cecilia del Alcor'), " +
                    " ( 34, 'Santa Cruz de Boedo'), " +
                    " ( 34, 'Santervás de la Vega'), " +
                    " ( 34, 'Santibáñez de Ecla'), " +
                    " ( 34, 'Santibáñez de la Peña'), " +
                    " ( 34, 'Santoyo'), " +
                    " ( 34, 'Serna (La)'), " +
                    " ( 34, 'Soto de Cerrato'), " +
                    " ( 34, 'Sotobañado y Priorato'), " +
                    " ( 34, 'Tabanera de Cerrato'), " +
                    " ( 34, 'Tabanera de Valdavia'), " +
                    " ( 34, 'Támara de Campos'), " +
                    " ( 34, 'Tariego de Cerrato'), " +
                    " ( 34, 'Torquemada'), " +
                    " ( 34, 'Torremormojón'), " +
                    " ( 34, 'Triollo'), " +
                    " ( 34, 'Valbuena de Pisuerga'), " +
                    " ( 34, 'Valdeolmillos'), " +
                    " ( 34, 'Valderrábano'), " +
                    " ( 34, 'Valde-Ucieza'), " +
                    " ( 34, 'Valle de Cerrato'), " +
                    " ( 34, 'Valle del Retortillo'), " +
                    " ( 34, 'Velilla del Río Carrión'), " +
                    " ( 34, 'Venta de Baños'), " +
                    " ( 34, 'Vertavillo'), " +
                    " ( 34, 'Vid de Ojeda (La)'), " +
                    " ( 34, 'Villabasta de Valdavia'), " +
                    " ( 34, 'Villacidaler'), " +
                    " ( 34, 'Villaconancio'), " +
                    " ( 34, 'Villada'), " +
                    " ( 34, 'Villaeles de Valdavia'), " +
                    " ( 34, 'Villahán'), " +
                    " ( 34, 'Villaherreros'), " +
                    " ( 34, 'Villalaco'), " +
                    " ( 34, 'Villalba de Guardo'), " +
                    " ( 34, 'Villalcázar de Sirga'), " +
                    " ( 34, 'Villalcón'), " +
                    " ( 34, 'Villalobón'), " +
                    " ( 34, 'Villaluenga de la Vega'), " +
                    " ( 34, 'Villamartín de Campos'), " +
                    " ( 34, 'Villamediana'), " +
                    " ( 34, 'Villameriel'), " +
                    " ( 34, 'Villamoronta'), " +
                    " ( 34, 'Villamuera de la Cueza'), " +
                    " ( 34, 'Villamuriel de Cerrato'), " +
                    " ( 34, 'Villanueva del Rebollar'), " +
                    " ( 34, 'Villanuño de Valdavia'), " +
                    " ( 34, 'Villaprovedo'), " +
                    " ( 34, 'Villarmentero de Campos'), " +
                    " ( 34, 'Villarrabé'), " +
                    " ( 34, 'Villarramiel'), " +
                    " ( 34, 'Villasarracino'), " +
                    " ( 34, 'Villasila de Valdavia'), " +
                    " ( 34, 'Villaturde'), " +
                    " ( 34, 'Villaumbrales'), " +
                    " ( 34, 'Villaviudas'), " +
                    " ( 34, 'Villerías de Campos'), " +
                    " ( 34, 'Villodre'), " +
                    " ( 34, 'Villodrigo'), " +
                    " ( 34, 'Villoldo'), " +
                    " ( 34, 'Villota del Páramo'), " +
                    " ( 34, 'Villovieco'), " +
                    " ( 35, 'Agaete'), " +
                    " ( 35, 'Agüimes'), " +
                    " ( 35, 'Aldea de San Nicolás (La)'), " +
                    " ( 35, 'Antigua'), " +
                    " ( 35, 'Arrecife'), " +
                    " ( 35, 'Artenara'), " +
                    " ( 35, 'Arucas'), " +
                    " ( 35, 'Betancuria'), " +
                    " ( 35, 'Firgas'), " +
                    " ( 35, 'Gáldar'), " +
                    " ( 35, 'Haría'), " +
                    " ( 35, 'Ingenio'), " +
                    " ( 35, 'Mogán'), " +
                    " ( 35, 'Moya (Las Palmas)'), " +
                    " ( 35, 'Oliva (La)'), " +
                    " ( 35, 'Pájara'), " +
                    " ( 35, 'Palmas de Gran Canaria (Las)'), " +
                    " ( 35, 'Puerto del Rosario'), " +
                    " ( 35, 'San Bartolomé'), " +
                    " ( 35, 'San Bartolomé de Tirajana'), " +
                    " ( 35, 'Santa Brígida'), " +
                    " ( 35, 'Santa Lucía de Tirajana'), " +
                    " ( 35, 'Santa María de Guía de Gran Canaria'), " +
                    " ( 35, 'Teguise'), " +
                    " ( 35, 'Tejeda'), " +
                    " ( 35, 'Telde'), " +
                    " ( 35, 'Teror'), " +
                    " ( 35, 'Tías'), " +
                    " ( 35, 'Tinajo'), " +
                    " ( 35, 'Tuineje'), " +
                    " ( 35, 'Valleseco'), " +
                    " ( 35, 'Valsequillo de Gran Canaria'), " +
                    " ( 35, 'Vega de San Mateo'), " +
                    " ( 35, 'Yaiza'), " +
                    " ( 36, 'Agolada'), " +
                    " ( 36, 'Arbo'), " +
                    " ( 36, 'Baiona'), " +
                    " ( 36, 'Barro'), " +
                    " ( 36, 'Bueu'), " +
                    " ( 36, 'Caldas de Reis'), " +
                    " ( 36, 'Cambados'), " +
                    " ( 36, 'Campo Lameiro'), " +
                    " ( 36, 'Cangas'), " +
                    " ( 36, 'Cañiza (A)'), " +
                    " ( 36, 'Catoira'), " +
                    " ( 36, 'Cerdedo'), " +
                    " ( 36, 'Cotobade'), " +
                    " ( 36, 'Covelo'), " +
                    " ( 36, 'Crecente'), " +
                    " ( 36, 'Cuntis'), " +
                    " ( 36, 'Dozón'), " +
                    " ( 36, 'Estrada (A)'), " +
                    " ( 36, 'Forcarei'), " +
                    " ( 36, 'Fornelos de Montes'), " +
                    " ( 36, 'Gondomar'), " +
                    " ( 36, 'Grove (O)'), " +
                    " ( 36, 'Guarda (A)'), " +
                    " ( 36, 'Illa de Arousa (A)'), " +
                    " ( 36, 'Lalín'), " +
                    " ( 36, 'Lama (A)'), " +
                    " ( 36, 'Marín'), " +
                    " ( 36, 'Meaño'), " +
                    " ( 36, 'Meis'), " +
                    " ( 36, 'Moaña'), " +
                    " ( 36, 'Mondariz'), " +
                    " ( 36, 'Mondariz-Balneario'), " +
                    " ( 36, 'Moraña'), " +
                    " ( 36, 'Mos'), " +
                    " ( 36, 'Neves (As)'), " +
                    " ( 36, 'Nigrán'), " +
                    " ( 36, 'Oia'), " +
                    " ( 36, 'Pazos de Borbén'), " +
                    " ( 36, 'Poio'), " +
                    " ( 36, 'Ponte Caldelas'), " +
                    " ( 36, 'Ponteareas'), " +
                    " ( 36, 'Pontecesures'), " +
                    " ( 36, 'Pontevedra'), " +
                    " ( 36, 'Porriño (O)'), " +
                    " ( 36, 'Portas'), " +
                    " ( 36, 'Redondela'), " +
                    " ( 36, 'Ribadumia'), " +
                    " ( 36, 'Rodeiro'), " +
                    " ( 36, 'Rosal (O)'), " +
                    " ( 36, 'Salceda de Caselas'), " +
                    " ( 36, 'Salvaterra de Miño'), " +
                    " ( 36, 'Sanxenxo'), " +
                    " ( 36, 'Silleda'), " +
                    " ( 36, 'Soutomaior'), " +
                    " ( 36, 'Tomiño'), " +
                    " ( 36, 'Tui'), " +
                    " ( 36, 'Valga'), " +
                    " ( 36, 'Vigo'), " +
                    " ( 36, 'Vila de Cruces'), " +
                    " ( 36, 'Vilaboa'), " +
                    " ( 36, 'Vilagarcía de Arousa'), " +
                    " ( 36, 'Vilanova de Arousa'), " +
                    " ( 37, 'Abusejo'), " +
                    " ( 37, 'Agallas'), " +
                    " ( 37, 'Ahigal de los Aceiteros'), " +
                    " ( 37, 'Ahigal de Villarino'), " +
                    " ( 37, 'Alameda de Gardón (La)'), " +
                    " ( 37, 'Alamedilla (La)'), " +
                    " ( 37, 'Alaraz'), " +
                    " ( 37, 'Alba de Tormes'), " +
                    " ( 37, 'Alba de Yeltes'), " +
                    " ( 37, 'Alberca (La)'), " +
                    " ( 37, 'Alberguería de Argañán (La)'), " +
                    " ( 37, 'Alconada'), " +
                    " ( 37, 'Aldea del Obispo'), " +
                    " ( 37, 'Aldeacipreste'), " +
                    " ( 37, 'Aldeadávila de la Ribera'), " +
                    " ( 37, 'Aldealengua'), " +
                    " ( 37, 'Aldeanueva de Figueroa'), " +
                    " ( 37, 'Aldeanueva de la Sierra'), " +
                    " ( 37, 'Aldearrodrigo'), " +
                    " ( 37, 'Aldearrubia'), " +
                    " ( 37, 'Aldeaseca de Alba'), " +
                    " ( 37, 'Aldeaseca de la Frontera'), " +
                    " ( 37, 'Aldeatejada'), " +
                    " ( 37, 'Aldeavieja de Tormes'), " +
                    " ( 37, 'Aldehuela de la Bóveda'), " +
                    " ( 37, 'Aldehuela de Yeltes'), " +
                    " ( 37, 'Almenara de Tormes'), " +
                    " ( 37, 'Almendra'), " +
                    " ( 37, 'Anaya de Alba'), " +
                    " ( 37, 'Añover de Tormes'), " +
                    " ( 37, 'Arabayona de Mógica'), " +
                    " ( 37, 'Arapiles'), " +
                    " ( 37, 'Arcediano'), " +
                    " ( 37, 'Arco (El)'), " +
                    " ( 37, 'Armenteros'), " +
                    " ( 37, 'Atalaya (La)'), " +
                    " ( 37, 'Babilafuente'), " +
                    " ( 37, 'Bañobárez'), " +
                    " ( 37, 'Barbadillo'), " +
                    " ( 37, 'Barbalos'), " +
                    " ( 37, 'Barceo'), " +
                    " ( 37, 'Barruecopardo'), " +
                    " ( 37, 'Bastida (La)'), " +
                    " ( 37, 'Béjar'), " +
                    " ( 37, 'Beleña'), " +
                    " ( 37, 'Bermellar'), " +
                    " ( 37, 'Berrocal de Huebra'), " +
                    " ( 37, 'Berrocal de Salvatierra'), " +
                    " ( 37, 'Boada'), " +
                    " ( 37, 'Bodón (El)'), " +
                    " ( 37, 'Bogajo'), " +
                    " ( 37, 'Bouza (La)'), " +
                    " ( 37, 'Bóveda del Río Almar'), " +
                    " ( 37, 'Brincones'), " +
                    " ( 37, 'Buenamadre'), " +
                    " ( 37, 'Buenavista'), " +
                    " ( 37, 'Cabaco (El)'), " +
                    " ( 37, 'Cabeza de Béjar (La)'), " +
                    " ( 37, 'Cabeza del Caballo'), " +
                    " ( 37, 'Cabezabellosa de la Calzada'), " +
                    " ( 37, 'Cabrerizos'), " +
                    " ( 37, 'Cabrillas'), " +
                    " ( 37, 'Calvarrasa de Abajo'), " +
                    " ( 37, 'Calvarrasa de Arriba'), " +
                    " ( 37, 'Calzada de Béjar (La)'), " +
                    " ( 37, 'Calzada de Don Diego'), " +
                    " ( 37, 'Calzada de Valdunciel'), " +
                    " ( 37, 'Campillo de Azaba'), " +
                    " ( 37, 'Campo de Peñaranda (El)'), " +
                    " ( 37, 'Candelario'), " +
                    " ( 37, 'Canillas de Abajo'), " +
                    " ( 37, 'Cantagallo'), " +
                    " ( 37, 'Cantalapiedra'), " +
                    " ( 37, 'Cantalpino'), " +
                    " ( 37, 'Cantaracillo'), " +
                    " ( 37, 'Carbajosa de la Sagrada'), " +
                    " ( 37, 'Carpio de Azaba'), " +
                    " ( 37, 'Carrascal de Barregas'), " +
                    " ( 37, 'Carrascal del Obispo'), " +
                    " ( 37, 'Casafranca'), " +
                    " ( 37, 'Casas del Conde (Las)'), " +
                    " ( 37, 'Casillas de Flores'), " +
                    " ( 37, 'Castellanos de Moriscos'), " +
                    " ( 37, 'Castellanos de Villiquera'), " +
                    " ( 37, 'Castillejo de Martín Viejo'), " +
                    " ( 37, 'Castraz'), " +
                    " ( 37, 'Cepeda'), " +
                    " ( 37, 'Cereceda de la Sierra'), " +
                    " ( 37, 'Cerezal de Peñahorcada'), " +
                    " ( 37, 'Cerralbo'), " +
                    " ( 37, 'Cerro (El)'), " +
                    " ( 37, 'Cespedosa de Tormes'), " +
                    " ( 37, 'Chagarcía Medianero'), " +
                    " ( 37, 'Cilleros de la Bastida'), " +
                    " ( 37, 'Cipérez'), " +
                    " ( 37, 'Ciudad Rodrigo'), " +
                    " ( 37, 'Coca de Alba'), " +
                    " ( 37, 'Colmenar de Montemayor'), " +
                    " ( 37, 'Cordovilla'), " +
                    " ( 37, 'Cristóbal'), " +
                    " ( 37, 'Cubo de Don Sancho (El)'), " +
                    " ( 37, 'Dios le Guarde'), " +
                    " ( 37, 'Doñinos de Ledesma'), " +
                    " ( 37, 'Doñinos de Salamanca'), " +
                    " ( 37, 'Ejeme'), " +
                    " ( 37, 'Encina (La)'), " +
                    " ( 37, 'Encina de San Silvestre'), " +
                    " ( 37, 'Encinas de Abajo'), " +
                    " ( 37, 'Encinas de Arriba'), " +
                    " ( 37, 'Encinasola de los Comendadores'), " +
                    " ( 37, 'Endrinal'), " +
                    " ( 37, 'Escurial de la Sierra'), " +
                    " ( 37, 'Espadaña'), " +
                    " ( 37, 'Espeja'), " +
                    " ( 37, 'Espino de la Orbada'), " +
                    " ( 37, 'Florida de Liébana'), " +
                    " ( 37, 'Forfoleda'), " +
                    " ( 37, 'Frades de la Sierra'), " +
                    " ( 37, 'Fregeneda (La)'), " +
                    " ( 37, 'Fresnedoso'), " +
                    " ( 37, 'Fresno Alhándiga'), " +
                    " ( 37, 'Fuente de San Esteban (La)'), " +
                    " ( 37, 'Fuenteguinaldo'), " +
                    " ( 37, 'Fuenteliante'), " +
                    " ( 37, 'Fuenterroble de Salvatierra'), " +
                    " ( 37, 'Fuentes de Béjar'), " +
                    " ( 37, 'Fuentes de Oñoro'), " +
                    " ( 37, 'Gajates'), " +
                    " ( 37, 'Galindo y Perahuy'), " +
                    " ( 37, 'Galinduste'), " +
                    " ( 37, 'Galisancho'), " +
                    " ( 37, 'Gallegos de Argañán'), " +
                    " ( 37, 'Gallegos de Solmirón'), " +
                    " ( 37, 'Garcibuey'), " +
                    " ( 37, 'Garcihernández'), " +
                    " ( 37, 'Garcirrey'), " +
                    " ( 37, 'Gejuelo del Barro'), " +
                    " ( 37, 'Golpejas'), " +
                    " ( 37, 'Gomecello'), " +
                    " ( 37, 'Guadramiro'), " +
                    " ( 37, 'Guijo de Ávila'), " +
                    " ( 37, 'Guijuelo'), " +
                    " ( 37, 'Herguijuela de Ciudad Rodrigo'), " +
                    " ( 37, 'Herguijuela de la Sierra'), " +
                    " ( 37, 'Herguijuela del Campo'), " +
                    " ( 37, 'Hinojosa de Duero'), " +
                    " ( 37, 'Horcajo de Montemayor'), " +
                    " ( 37, 'Horcajo Medianero'), " +
                    " ( 37, 'Hoya (La)'), " +
                    " ( 37, 'Huerta'), " +
                    " ( 37, 'Iruelos'), " +
                    " ( 37, 'Ituero de Azaba'), " +
                    " ( 37, 'Juzbado'), " +
                    " ( 37, 'Lagunilla'), " +
                    " ( 37, 'Larrodrigo'), " +
                    " ( 37, 'Ledesma'), " +
                    " ( 37, 'Ledrada'), " +
                    " ( 37, 'Linares de Riofrío'), " +
                    " ( 37, 'Lumbrales'), " +
                    " ( 37, 'Machacón'), " +
                    " ( 37, 'Macotera'), " +
                    " ( 37, 'Madroñal'), " +
                    " ( 37, 'Maíllo (El)'), " +
                    " ( 37, 'Malpartida'), " +
                    " ( 37, 'Mancera de Abajo'), " +
                    " ( 37, 'Manzano (El)'), " +
                    " ( 37, 'Martiago'), " +
                    " ( 37, 'Martín de Yeltes'), " +
                    " ( 37, 'Martinamor'), " +
                    " ( 37, 'Masueco'), " +
                    " ( 37, 'Mata de Ledesma (La)'), " +
                    " ( 37, 'Matilla de los Caños del Río'), " +
                    " ( 37, 'Maya (La)'), " +
                    " ( 37, 'Membribe de la Sierra'), " +
                    " ( 37, 'Mieza'), " +
                    " ( 37, 'Milano (El)'), " +
                    " ( 37, 'Miranda de Azán'), " +
                    " ( 37, 'Miranda del Castañar'), " +
                    " ( 37, 'Mogarraz'), " +
                    " ( 37, 'Molinillo'), " +
                    " ( 37, 'Monforte de la Sierra'), " +
                    " ( 37, 'Monleón'), " +
                    " ( 37, 'Monleras'), " +
                    " ( 37, 'Monsagro'), " +
                    " ( 37, 'Montejo'), " +
                    " ( 37, 'Montemayor del Río'), " +
                    " ( 37, 'Monterrubio de Armuña'), " +
                    " ( 37, 'Monterrubio de la Sierra'), " +
                    " ( 37, 'Morasverdes'), " +
                    " ( 37, 'Morille'), " +
                    " ( 37, 'Moríñigo'), " +
                    " ( 37, 'Moriscos'), " +
                    " ( 37, 'Moronta'), " +
                    " ( 37, 'Mozárbez'), " +
                    " ( 37, 'Narros de Matalayegua'), " +
                    " ( 37, 'Nava de Béjar'), " +
                    " ( 37, 'Nava de Francia'), " +
                    " ( 37, 'Nava de Sotrobal'), " +
                    " ( 37, 'Navacarros'), " +
                    " ( 37, 'Navales'), " +
                    " ( 37, 'Navalmoral de Béjar'), " +
                    " ( 37, 'Navamorales'), " +
                    " ( 37, 'Navarredonda de la Rinconada'), " +
                    " ( 37, 'Navasfrías'), " +
                    " ( 37, 'Negrilla de Palencia'), " +
                    " ( 37, 'Olmedo de Camaces'), " +
                    " ( 37, 'Orbada (La)'), " +
                    " ( 37, 'Pajares de la Laguna'), " +
                    " ( 37, 'Palacios del Arzobispo'), " +
                    " ( 37, 'Palaciosrubios'), " +
                    " ( 37, 'Palencia de Negrilla'), " +
                    " ( 37, 'Parada de Arriba'), " +
                    " ( 37, 'Parada de Rubiales'), " +
                    " ( 37, 'Paradinas de San Juan'), " +
                    " ( 37, 'Pastores'), " +
                    " ( 37, 'Payo (El)'), " +
                    " ( 37, 'Pedraza de Alba'), " +
                    " ( 37, 'Pedrosillo de Alba'), " +
                    " ( 37, 'Pedrosillo de los Aires'), " +
                    " ( 37, 'Pedrosillo el Ralo'), " +
                    " ( 37, 'Pedroso de la Armuña (El)'), " +
                    " ( 37, 'Pelabravo'), " +
                    " ( 37, 'Pelarrodríguez'), " +
                    " ( 37, 'Pelayos'), " +
                    " ( 37, 'Peña (La)'), " +
                    " ( 37, 'Peñacaballera'), " +
                    " ( 37, 'Peñaparda'), " +
                    " ( 37, 'Peñaranda de Bracamonte'), " +
                    " ( 37, 'Peñarandilla'), " +
                    " ( 37, 'Peralejos de Abajo'), " +
                    " ( 37, 'Peralejos de Arriba'), " +
                    " ( 37, 'Pereña de la Ribera'), " +
                    " ( 37, 'Peromingo'), " +
                    " ( 37, 'Pinedas'), " +
                    " ( 37, 'Pino de Tormes (El)'), " +
                    " ( 37, 'Pitiegua'), " +
                    " ( 37, 'Pizarral'), " +
                    " ( 37, 'Poveda de las Cintas'), " +
                    " ( 37, 'Pozos de Hinojo'), " +
                    " ( 37, 'Puebla de Azaba'), " +
                    " ( 37, 'Puebla de San Medel'), " +
                    " ( 37, 'Puebla de Yeltes'), " +
                    " ( 37, 'Puente del Congosto'), " +
                    " ( 37, 'Puertas'), " +
                    " ( 37, 'Puerto de Béjar'), " +
                    " ( 37, 'Puerto Seguro'), " +
                    " ( 37, 'Rágama'), " +
                    " ( 37, 'Redonda (La)'), " +
                    " ( 37, 'Retortillo'), " +
                    " ( 37, 'Rinconada de la Sierra (La)'), " +
                    " ( 37, 'Robleda'), " +
                    " ( 37, 'Robliza de Cojos'), " +
                    " ( 37, 'Rollán'), " +
                    " ( 37, 'Saelices el Chico'), " +
                    " ( 37, 'Sagrada (La)'), " +
                    " ( 37, 'Sahugo (El)'), " +
                    " ( 37, 'Salamanca'), " +
                    " ( 37, 'Saldeana'), " +
                    " ( 37, 'Salmoral'), " +
                    " ( 37, 'Salvatierra de Tormes'), " +
                    " ( 37, 'San Cristóbal de la Cuesta'), " +
                    " ( 37, 'San Esteban de la Sierra'), " +
                    " ( 37, 'San Felices de los Gallegos'), " +
                    " ( 37, 'San Martín del Castañar'), " +
                    " ( 37, 'San Miguel de Valero'), " +
                    " ( 37, 'San Miguel del Robledo'), " +
                    " ( 37, 'San Morales'), " +
                    " ( 37, 'San Muñoz'), " +
                    " ( 37, 'San Pedro de Rozados'), " +
                    " ( 37, 'San Pedro del Valle'), " +
                    " ( 37, 'San Pelayo de Guareña'), " +
                    " ( 37, 'Sanchón de la Ribera'), " +
                    " ( 37, 'Sanchón de la Sagrada'), " +
                    " ( 37, 'Sanchotello'), " +
                    " ( 37, 'Sancti-Spíritus (Salamanca)'), " +
                    " ( 37, 'Sando'), " +
                    " ( 37, 'Santa María de Sando'), " +
                    " ( 37, 'Santa Marta de Tormes'), " +
                    " ( 37, 'Santiago de la Puebla'), " +
                    " ( 37, 'Santibáñez de Béjar'), " +
                    " ( 37, 'Santibáñez de la Sierra'), " +
                    " ( 37, 'Santiz'), " +
                    " ( 37, 'Santos (Los)'), " +
                    " ( 37, 'Sardón de los Frailes'), " +
                    " ( 37, 'Saucelle'), " +
                    " ( 37, 'Sepulcro-Hilario'), " +
                    " ( 37, 'Sequeros'), " +
                    " ( 37, 'Serradilla del Arroyo'), " +
                    " ( 37, 'Serradilla del Llano'), " +
                    " ( 37, 'Sierpe (La)'), " +
                    " ( 37, 'Sieteiglesias de Tormes'), " +
                    " ( 37, 'Sobradillo'), " +
                    " ( 37, 'Sorihuela'), " +
                    " ( 37, 'Sotoserrano'), " +
                    " ( 37, 'Tabera de Abajo'), " +
                    " ( 37, 'Tala (La)'), " +
                    " ( 37, 'Tamames'), " +
                    " ( 37, 'Tarazona de Guareña'), " +
                    " ( 37, 'Tardáguila'), " +
                    " ( 37, 'Tejado (El)'), " +
                    " ( 37, 'Tejeda y Segoyuela'), " +
                    " ( 37, 'Tenebrón'), " +
                    " ( 37, 'Terradillos'), " +
                    " ( 37, 'Topas'), " +
                    " ( 37, 'Tordillos'), " +
                    " ( 37, 'Tornadizo (El)'), " +
                    " ( 37, 'Torresmenudas'), " +
                    " ( 37, 'Trabanca'), " +
                    " ( 37, 'Tremedal de Tormes'), " +
                    " ( 37, 'Valdecarros'), " +
                    " ( 37, 'Valdefuentes de Sangusín'), " +
                    " ( 37, 'Valdehijaderos'), " +
                    " ( 37, 'Valdelacasa'), " +
                    " ( 37, 'Valdelageve'), " +
                    " ( 37, 'Valdelosa'), " +
                    " ( 37, 'Valdemierque'), " +
                    " ( 37, 'Valderrodrigo'), " +
                    " ( 37, 'Valdunciel'), " +
                    " ( 37, 'Valero'), " +
                    " ( 37, 'Vallejera de Riofrío'), " +
                    " ( 37, 'Valsalabroso'), " +
                    " ( 37, 'Valverde de Valdelacasa'), " +
                    " ( 37, 'Valverdón'), " +
                    " ( 37, 'Vecinos'), " +
                    " ( 37, 'Vega de Tirados'), " +
                    " ( 37, 'Veguillas (Las)'), " +
                    " ( 37, 'Vellés (La)'), " +
                    " ( 37, 'Ventosa del Río Almar'), " +
                    " ( 37, 'Vídola (La)'), " +
                    " ( 37, 'Villaflores'), " +
                    " ( 37, 'Villagonzalo de Tormes'), " +
                    " ( 37, 'Villalba de los Llanos'), " +
                    " ( 37, 'Villamayor'), " +
                    " ( 37, 'Villanueva del Conde'), " +
                    " ( 37, 'Villar de Argañán'), " +
                    " ( 37, 'Villar de Ciervo'), " +
                    " ( 37, 'Villar de Gallimazo'), " +
                    " ( 37, 'Villar de la Yegua'), " +
                    " ( 37, 'Villar de Peralonso'), " +
                    " ( 37, 'Villar de Samaniego'), " +
                    " ( 37, 'Villares de la Reina'), " +
                    " ( 37, 'Villares de Yeltes'), " +
                    " ( 37, 'Villarino de los Aires'), " +
                    " ( 37, 'Villarmayor'), " +
                    " ( 37, 'Villarmuerto'), " +
                    " ( 37, 'Villasbuenas'), " +
                    " ( 37, 'Villasdardo'), " +
                    " ( 37, 'Villaseco de los Gamitos'), " +
                    " ( 37, 'Villaseco de los Reyes'), " +
                    " ( 37, 'Villasrubias'), " +
                    " ( 37, 'Villaverde de Guareña'), " +
                    " ( 37, 'Villavieja de Yeltes'), " +
                    " ( 37, 'Villoria'), " +
                    " ( 37, 'Villoruela'), " +
                    " ( 37, 'Vilvestre'), " +
                    " ( 37, 'Vitigudino'), " +
                    " ( 37, 'Yecla de Yeltes'), " +
                    " ( 37, 'Zamarra'), " +
                    " ( 37, 'Zamayón'), " +
                    " ( 37, 'Zarapicos'), " +
                    " ( 37, 'Zarza de Pumareda (La)'), " +
                    " ( 37, 'Zorita de la Frontera'), " +
                    " ( 38, 'Adeje'), " +
                    " ( 38, 'Agulo'), " +
                    " ( 38, 'Alajeró'), " +
                    " ( 38, 'Arafo'), " +
                    " ( 38, 'Arico'), " +
                    " ( 38, 'Arona'), " +
                    " ( 38, 'Barlovento'), " +
                    " ( 38, 'Breña Alta'), " +
                    " ( 38, 'Breña Baja'), " +
                    " ( 38, 'Buenavista del Norte'), " +
                    " ( 38, 'Candelaria'), " +
                    " ( 38, 'Fasnia'), " +
                    " ( 38, 'Frontera'), " +
                    " ( 38, 'Fuencaliente de la Palma'), " +
                    " ( 38, 'Garachico'), " +
                    " ( 38, 'Garafía'), " +
                    " ( 38, 'Granadilla de Abona'), " +
                    " ( 38, 'Guancha (La)'), " +
                    " ( 38, 'Guía de Isora'), " +
                    " ( 38, 'Güímar'), " +
                    " ( 38, 'Hermigua'), " +
                    " ( 38, 'Icod de los Vinos'), " +
                    " ( 38, 'Llanos de Aridane (Los)'), " +
                    " ( 38, 'Matanza de Acentejo (La)'), " +
                    " ( 38, 'Orotava (La)'), " +
                    " ( 38, 'Paso (El)'), " +
                    " ( 38, 'Puerto de la Cruz'), " +
                    " ( 38, 'Puntagorda'), " +
                    " ( 38, 'Puntallana'), " +
                    " ( 38, 'Realejos (Los)'), " +
                    " ( 38, 'Rosario (El)'), " +
                    " ( 38, 'San Andrés y Sauces'), " +
                    " ( 38, 'San Cristóbal de La Laguna'), " +
                    " ( 38, 'San Juan de la Rambla'), " +
                    " ( 38, 'San Miguel de Abona') " +
                    " ( 38, 'San Sebastián de la Gomera'), " +
                    " ( 38, 'Santa Cruz de la Palma'), " +
                    " ( 38, 'Santa Cruz de Tenerife'), " +
                    " ( 38, 'Santa Úrsula'), " +
                    " ( 38, 'Santiago del Teide'), " +
                    " ( 38, 'Sauzal (El)'), " +
                    " ( 38, 'Silos (Los)'), " +
                    " ( 38, 'Tacoronte'), " +
                    " ( 38, 'Tanque (El)'), " +
                    " ( 38, 'Tazacorte'), " +
                    " ( 38, 'Tegueste'), " +
                    " ( 38, 'Tijarafe'), " +
                    " ( 38, 'Valle Gran Rey'), " +
                    " ( 38, 'Vallehermoso'), " +
                    " ( 38, 'Valverde'), " +
                    " ( 38, 'Victoria de Acentejo (La)'), " +
                    " ( 38, 'Vilaflor'), " +
                    " ( 38, 'Villa de Mazo'), " +
                    " ( 39, 'Alfoz de Lloredo'), " +
                    " ( 39, 'Ampuero'), " +
                    " ( 39, 'Anievas'), " +
                    " ( 39, 'Arenas de Iguña'), " +
                    " ( 39, 'Argoños'), " +
                    " ( 39, 'Arnuero'), " +
                    " ( 39, 'Arredondo'), " +
                    " ( 39, 'Astillero (El)'), " +
                    " ( 39, 'Bárcena de Cicero'), " +
                    " ( 39, 'Bárcena de Pie de Concha'), " +
                    " ( 39, 'Bareyo'), " +
                    " ( 39, 'Cabezón de la Sal'), " +
                    " ( 39, 'Cabezón de Liébana'), " +
                    " ( 39, 'Cabuérniga'), " +
                    " ( 39, 'Camaleño'), " +
                    " ( 39, 'Camargo'), " +
                    " ( 39, 'Campoo de Enmedio'), " +
                    " ( 39, 'Campoo de Yuso'), " +
                    " ( 39, 'Cartes'), " +
                    " ( 39, 'Castañeda'), " +
                    " ( 39, 'Castro-Urdiales'), " +
                    " ( 39, 'Cieza (Cantabria)'), " +
                    " ( 39, 'Cillorigo de Liébana'), " +
                    " ( 39, 'Colindres'), " +
                    " ( 39, 'Comillas'), " +
                    " ( 39, 'Corrales de Buelna (Los)'), " +
                    " ( 39, 'Corvera de Toranzo'), " +
                    " ( 39, 'Entrambasaguas'), " +
                    " ( 39, 'Escalante'), " +
                    " ( 39, 'Guriezo'), " +
                    " ( 39, 'Hazas de Cesto'), " +
                    " ( 39, 'Hermandad de Campoo de Suso'), " +
                    " ( 39, 'Herrerías'), " +
                    " ( 39, 'Lamasón'), " +
                    " ( 39, 'Laredo'), " +
                    " ( 39, 'Liendo'), " +
                    " ( 39, 'Liérganes'), " +
                    " ( 39, 'Limpias'), " +
                    " ( 39, 'Luena'), " +
                    " ( 39, 'Marina de Cudeyo'), " +
                    " ( 39, 'Mazcuerras'), " +
                    " ( 39, 'Medio Cudeyo'), " +
                    " ( 39, 'Meruelo'), " +
                    " ( 39, 'Miengo'), " +
                    " ( 39, 'Miera'), " +
                    " ( 39, 'Molledo'), " +
                    " ( 39, 'Noja'), " +
                    " ( 39, 'Penagos'), " +
                    " ( 39, 'Peñarrubia'), " +
                    " ( 39, 'Pesaguero'), " +
                    " ( 39, 'Pesquera'), " +
                    " ( 39, 'Piélagos'), " +
                    " ( 39, 'Polaciones'), " +
                    " ( 39, 'Polanco'), " +
                    " ( 39, 'Potes'), " +
                    " ( 39, 'Puente Viesgo'), " +
                    " ( 39, 'Ramales de la Victoria'), " +
                    " ( 39, 'Rasines'), " +
                    " ( 39, 'Reinosa'), " +
                    " ( 39, 'Reocín'), " +
                    " ( 39, 'Ribamontán al Mar'), " +
                    " ( 39, 'Ribamontán al Monte'), " +
                    " ( 39, 'Rionansa'), " +
                    " ( 39, 'Riotuerto'), " +
                    " ( 39, 'Rozas de Valdearroyo (Las)'), " +
                    " ( 39, 'Ruente'), " +
                    " ( 39, 'Ruesga'), " +
                    " ( 39, 'Ruiloba'), " +
                    " ( 39, 'San Felices de Buelna'), " +
                    " ( 39, 'San Miguel de Aguayo'), " +
                    " ( 39, 'San Pedro del Romeral'), " +
                    " ( 39, 'San Roque de Riomiera'), " +
                    " ( 39, 'San Vicente de la Barquera'), " +
                    " ( 39, 'Santa Cruz de Bezana'), " +
                    " ( 39, 'Santa María de Cayón'), " +
                    " ( 39, 'Santander'), " +
                    " ( 39, 'Santillana del Mar'), " +
                    " ( 39, 'Santiurde de Reinosa'), " +
                    " ( 39, 'Santiurde de Toranzo'), " +
                    " ( 39, 'Santoña'), " +
                    " ( 39, 'Saro'), " +
                    " ( 39, 'Selaya'), " +
                    " ( 39, 'Soba'), " +
                    " ( 39, 'Solórzano'), " +
                    " ( 39, 'Suances'), " +
                    " ( 39, 'Tojos (Los)'), " +
                    " ( 39, 'Torrelavega'), " +
                    " ( 39, 'Tresviso'), " +
                    " ( 39, 'Tudanca'), " +
                    " ( 39, 'Udías'), " +
                    " ( 39, 'Val de San Vicente'), " +
                    " ( 39, 'Valdáliga'), " +
                    " ( 39, 'Valdeolea'), " +
                    " ( 39, 'Valdeprado del Río'), " +
                    " ( 39, 'Valderredible'), " +
                    " ( 39, 'Valle de Villaverde'), " +
                    " ( 39, 'Vega de Liébana'), " +
                    " ( 39, 'Vega de Pas'), " +
                    " ( 39, 'Villacarriedo'), " +
                    " ( 39, 'Villaescusa'), " +
                    " ( 39, 'Villafufre'), " +
                    " ( 39, 'Voto'), " +
                    " ( 40, 'Abades'), " +
                    " ( 40, 'Adrada de Pirón'), " +
                    " ( 40, 'Adrados'), " +
                    " ( 40, 'Aguilafuente'), " +
                    " ( 40, 'Alconada de Maderuelo'), " +
                    " ( 40, 'Aldea Real'), " +
                    " ( 40, 'Aldealcorvo'), " +
                    " ( 40, 'Aldealengua de Pedraza'), " +
                    " ( 40, 'Aldealengua de Santa María'), " +
                    " ( 40, 'Aldeanueva de la Serrezuela'), " +
                    " ( 40, 'Aldeanueva del Codonal'), " +
                    " ( 40, 'Aldeasoña'), " +
                    " ( 40, 'Aldehorno'), " +
                    " ( 40, 'Aldehuela del Codonal'), " +
                    " ( 40, 'Aldeonte'), " +
                    " ( 40, 'Anaya'), " +
                    " ( 40, 'Añe'), " +
                    " ( 40, 'Arahuetes'), " +
                    " ( 40, 'Arcones'), " +
                    " ( 40, 'Arevalillo de Cega'), " +
                    " ( 40, 'Armuña'), " +
                    " ( 40, 'Ayllón'), " +
                    " ( 40, 'Barbolla'), " +
                    " ( 40, 'Basardilla'), " +
                    " ( 40, 'Bercial'), " +
                    " ( 40, 'Bercimuel'), " +
                    " ( 40, 'Bernardos'), " +
                    " ( 40, 'Bernuy de Porreros'), " +
                    " ( 40, 'Boceguillas'), " +
                    " ( 40, 'Brieva'), " +
                    " ( 40, 'Caballar'), " +
                    " ( 40, 'Cabañas de Polendos'), " +
                    " ( 40, 'Cabezuela'), " +
                    " ( 40, 'Calabazas de Fuentidueña'), " +
                    " ( 40, 'Campo de San Pedro'), " +
                    " ( 40, 'Cantalejo'), " +
                    " ( 40, 'Cantimpalos'), " +
                    " ( 40, 'Carbonero el Mayor'), " +
                    " ( 40, 'Carrascal del Río'), " +
                    " ( 40, 'Casla'), " +
                    " ( 40, 'Castillejo de Mesleón'), " +
                    " ( 40, 'Castro de Fuentidueña'), " +
                    " ( 40, 'Castrojimeno'), " +
                    " ( 40, 'Castroserna de Abajo'), " +
                    " ( 40, 'Castroserracín'), " +
                    " ( 40, 'Cedillo de la Torre'), " +
                    " ( 40, 'Cerezo de Abajo'), " +
                    " ( 40, 'Cerezo de Arriba'), " +
                    " ( 40, 'Chañe'), " +
                    " ( 40, 'Cilleruelo de San Mamés'), " +
                    " ( 40, 'Cobos de Fuentidueña'), " +
                    " ( 40, 'Coca'), " +
                    " ( 40, 'Codorniz'), " +
                    " ( 40, 'Collado Hermoso'), " +
                    " ( 40, 'Condado de Castilnovo'), " +
                    " ( 40, 'Corral de Ayllón'), " +
                    " ( 40, 'Cozuelos de Fuentidueña'), " +
                    " ( 40, 'Cubillo'), " +
                    " ( 40, 'Cuéllar'), " +
                    " ( 40, 'Cuevas de Provanco'), " +
                    " ( 40, 'Domingo García'), " +
                    " ( 40, 'Donhierro'), " +
                    " ( 40, 'Duruelo'), " +
                    " ( 40, 'Encinas'), " +
                    " ( 40, 'Encinillas'), " +
                    " ( 40, 'Escalona del Prado'), " +
                    " ( 40, 'Escarabajosa de Cabezas'), " +
                    " ( 40, 'Escobar de Polendos'), " +
                    " ( 40, 'Espinar (El)'), " +
                    " ( 40, 'Espirdo'), " +
                    " ( 40, 'Fresneda de Cuéllar'), " +
                    " ( 40, 'Fresno de Cantespino'), " +
                    " ( 40, 'Fresno de la Fuente'), " +
                    " ( 40, 'Frumales'), " +
                    " ( 40, 'Fuente de Santa Cruz'), " +
                    " ( 40, 'Fuente el Olmo de Fuentidueña'), " +
                    " ( 40, 'Fuente el Olmo de Íscar'), " +
                    " ( 40, 'Fuentepelayo'), " +
                    " ( 40, 'Fuentepiñel'), " +
                    " ( 40, 'Fuenterrebollo'), " +
                    " ( 40, 'Fuentesaúco de Fuentidueña'), " +
                    " ( 40, 'Fuentesoto'), " +
                    " ( 40, 'Fuentidueña'), " +
                    " ( 40, 'Gallegos'), " +
                    " ( 40, 'Garcillán'), " +
                    " ( 40, 'Gomezserracín'), " +
                    " ( 40, 'Grajera'), " +
                    " ( 40, 'Honrubia de la Cuesta'), " +
                    " ( 40, 'Hontalbilla'), " +
                    " ( 40, 'Hontanares de Eresma'), " +
                    " ( 40, 'Huertos (Los)'), " +
                    " ( 40, 'Ituero y Lama'), " +
                    " ( 40, 'Juarros de Riomoros'), " +
                    " ( 40, 'Juarros de Voltoya'), " +
                    " ( 40, 'Labajos'), " +
                    " ( 40, 'Laguna de Contreras'), " +
                    " ( 40, 'Languilla'), " +
                    " ( 40, 'Lastras de Cuéllar'), " +
                    " ( 40, 'Lastras del Pozo'), " +
                    " ( 40, 'Lastrilla (La)'), " +
                    " ( 40, 'Losa (La)'), " +
                    " ( 40, 'Maderuelo'), " +
                    " ( 40, 'Marazoleja'), " +
                    " ( 40, 'Marazuela'), " +
                    " ( 40, 'Martín Miguel'), " +
                    " ( 40, 'Martín Muñoz de la Dehesa'), " +
                    " ( 40, 'Martín Muñoz de las Posadas'), " +
                    " ( 40, 'Marugán'), " +
                    " ( 40, 'Mata de Cuéllar'), " +
                    " ( 40, 'Matabuena'), " +
                    " ( 40, 'Matilla (La)'), " +
                    " ( 40, 'Melque de Cercos'), " +
                    " ( 40, 'Membibre de la Hoz'), " +
                    " ( 40, 'Migueláñez'), " +
                    " ( 40, 'Montejo de Arévalo'), " +
                    " ( 40, 'Montejo de la Vega de la Serrezuela'), " +
                    " ( 40, 'Monterrubio'), " +
                    " ( 40, 'Moral de Hornuez'), " +
                    " ( 40, 'Mozoncillo'), " +
                    " ( 40, 'Muñopedro'), " +
                    " ( 40, 'Muñoveros'), " +
                    " ( 40, 'Nava de la Asunción'), " +
                    " ( 40, 'Navafría'), " +
                    " ( 40, 'Navalilla'), " +
                    " ( 40, 'Navalmanzano'), " +
                    " ( 40, 'Navares de Ayuso'), " +
                    " ( 40, 'Navares de Enmedio'), " +
                    " ( 40, 'Navares de las Cuevas'), " +
                    " ( 40, 'Navas de Oro'), " +
                    " ( 40, 'Navas de Riofrío'), " +
                    " ( 40, 'Navas de San Antonio'), " +
                    " ( 40, 'Nieva'), " +
                    " ( 40, 'Olombrada'), " +
                    " ( 40, 'Orejana'), " +
                    " ( 40, 'Ortigosa de Pestaño'), " +
                    " ( 40, 'Ortigosa del Monte'), " +
                    " ( 40, 'Otero de Herreros'), " +
                    " ( 40, 'Pajarejos'), " +
                    " ( 40, 'Palazuelos de Eresma'), " +
                    " ( 40, 'Pedraza'), " +
                    " ( 40, 'Pelayos del Arroyo'), " +
                    " ( 40, 'Perosillo'), " +
                    " ( 40, 'Pinarejos'); ");
                    
                    stmt.executeUpdate("INSERT INTO `zk_poblacion` (`provincia`, `poblacion`) VALUES " +
                    " ( 40, 'Pinarnegrillo'), " +
                    " ( 40, 'Pradales'), " +
                    " ( 40, 'Prádena'), " +
                    " ( 40, 'Puebla de Pedraza'), " +
                    " ( 40, 'Rapariegos'), " +
                    " ( 40, 'Rebollo'), " +
                    " ( 40, 'Remondo'), " +
                    " ( 40, 'Riaguas de San Bartolomé'), " +
                    " ( 40, 'Riaza'), " +
                    " ( 40, 'Ribota'), " +
                    " ( 40, 'Riofrío de Riaza'), " +
                    " ( 40, 'Roda de Eresma'), " +
                    " ( 40, 'Sacramenia'), " +
                    " ( 40, 'Samboal'), " +
                    " ( 40, 'San Cristóbal de Cuéllar'), " +
                    " ( 40, 'San Cristóbal de la Vega'), " +
                    " ( 40, 'San Cristóbal de Segovia'), " +
                    " ( 40, 'San Ildefonso'), " +
                    " ( 40, 'San Martín y Mudrián'), " +
                    " ( 40, 'San Miguel de Bernuy'), " +
                    " ( 40, 'San Pedro de Gaíllos'), " +
                    " ( 40, 'Sanchonuño'), " +
                    " ( 40, 'Sangarcía'), " +
                    " ( 40, 'Santa María la Real de Nieva'), " +
                    " ( 40, 'Santa Marta del Cerro'), " +
                    " ( 40, 'Santiuste de Pedraza'), " +
                    " ( 40, 'Santiuste de San Juan Bautista'), " +
                    " ( 40, 'Santo Domingo de Pirón'), " +
                    " ( 40, 'Santo Tomé del Puerto'), " +
                    " ( 40, 'Sauquillo de Cabezas'), " +
                    " ( 40, 'Sebúlcor'), " +
                    " ( 40, 'Segovia'), " +
                    " ( 40, 'Sepúlveda'), " +
                    " ( 40, 'Sequera de Fresno'), " +
                    " ( 40, 'Sotillo'), " +
                    " ( 40, 'Sotosalbos'), " +
                    " ( 40, 'Tabanera la Luenga'), " +
                    " ( 40, 'Tolocirio'), " +
                    " ( 40, 'Torre Val de San Pedro'), " +
                    " ( 40, 'Torreadrada'), " +
                    " ( 40, 'Torrecaballeros'), " +
                    " ( 40, 'Torrecilla del Pinar'), " +
                    " ( 40, 'Torreiglesias'), " +
                    " ( 40, 'Trescasas'), " +
                    " ( 40, 'Turégano'), " +
                    " ( 40, 'Urueñas'), " +
                    " ( 40, 'Valdeprados'), " +
                    " ( 40, 'Valdevacas de Montejo'), " +
                    " ( 40, 'Valdevacas y Guijar'), " +
                    " ( 40, 'Valle de Tabladillo'), " +
                    " ( 40, 'Vallelado'), " +
                    " ( 40, 'Valleruela de Pedraza'), " +
                    " ( 40, 'Valleruela de Sepúlveda'), " +
                    " ( 40, 'Valseca'), " +
                    " ( 40, 'Valtiendas'), " +
                    " ( 40, 'Valverde del Majano'), " +
                    " ( 40, 'Veganzones'), " +
                    " ( 40, 'Vegas de Matute'), " +
                    " ( 40, 'Ventosilla y Tejadilla'), " +
                    " ( 40, 'Villacastín'), " +
                    " ( 40, 'Villaverde de Íscar'), " +
                    " ( 40, 'Villaverde de Montejo'), " +
                    " ( 40, 'Villeguillo'), " +
                    " ( 40, 'Yanguas de Eresma'), " +
                    " ( 40, 'Zarzuela del Monte'), " +
                    " ( 40, 'Zarzuela del Pinar'), " +
                    " ( 41, 'Aguadulce'), " +
                    " ( 41, 'Alanís'), " +
                    " ( 41, 'Albaida del Aljarafe'), " +
                    " ( 41, 'Alcalá de Guadaíra'), " +
                    " ( 41, 'Alcalá del Río'), " +
                    " ( 41, 'Alcolea del Río'), " +
                    " ( 41, 'Algaba (La)'), " +
                    " ( 41, 'Algámitas'), " +
                    " ( 41, 'Almadén de la Plata'), " +
                    " ( 41, 'Almensilla'), " +
                    " ( 41, 'Arahal'), " +
                    " ( 41, 'Aznalcázar'), " +
                    " ( 41, 'Aznalcóllar'), " +
                    " ( 41, 'Badolatosa'), " +
                    " ( 41, 'Benacazón'), " +
                    " ( 41, 'Bollullos de la Mitación'), " +
                    " ( 41, 'Bormujos'), " +
                    " ( 41, 'Brenes'), " +
                    " ( 41, 'Burguillos'), " +
                    " ( 41, 'Cabezas de San Juan (Las)'), " +
                    " ( 41, 'Camas'), " +
                    " ( 41, 'Campana (La)'), " +
                    " ( 41, 'Cantillana'), " +
                    " ( 41, 'Cañada Rosal'), " +
                    " ( 41, 'Carmona'), " +
                    " ( 41, 'Carrión de los Céspedes'), " +
                    " ( 41, 'Casariche'), " +
                    " ( 41, 'Castilblanco de los Arroyos'), " +
                    " ( 41, 'Castilleja de Guzmán'), " +
                    " ( 41, 'Castilleja de la Cuesta'), " +
                    " ( 41, 'Castilleja del Campo'), " +
                    " ( 41, 'Castillo de las Guardas (El)'), " +
                    " ( 41, 'Cazalla de la Sierra'), " +
                    " ( 41, 'Constantina'), " +
                    " ( 41, 'Coria del Río'), " +
                    " ( 41, 'Coripe'), " +
                    " ( 41, 'Coronil (El)'), " +
                    " ( 41, 'Corrales (Los)'), " +
                    " ( 41, 'Cuervo de Sevilla (El)'), " +
                    " ( 41, 'Dos Hermanas'), " +
                    " ( 41, 'Écija'), " +
                    " ( 41, 'Espartinas'), " +
                    " ( 41, 'Estepa'), " +
                    " ( 41, 'Fuentes de Andalucía'), " +
                    " ( 41, 'Garrobo (El)'), " +
                    " ( 41, 'Gelves'), " +
                    " ( 41, 'Gerena'), " +
                    " ( 41, 'Gilena'), " +
                    " ( 41, 'Gines'), " +
                    " ( 41, 'Guadalcanal'), " +
                    " ( 41, 'Guillena'), " +
                    " ( 41, 'Herrera'), " +
                    " ( 41, 'Huévar del Aljarafe'), " +
                    " ( 41, 'Isla Mayor'), " +
                    " ( 41, 'Lantejuela (La)'), " +
                    " ( 41, 'Lebrija'), " +
                    " ( 41, 'Lora de Estepa'), " +
                    " ( 41, 'Lora del Río'), " +
                    " ( 41, 'Luisiana (La)'), " +
                    " ( 41, 'Madroño (El)'), " +
                    " ( 41, 'Mairena del Alcor'), " +
                    " ( 41, 'Mairena del Aljarafe'), " +
                    " ( 41, 'Marchena'), " +
                    " ( 41, 'Marinaleda'), " +
                    " ( 41, 'Martín de la Jara'), " +
                    " ( 41, 'Molares (Los)'), " +
                    " ( 41, 'Montellano'), " +
                    " ( 41, 'Morón de la Frontera'), " +
                    " ( 41, 'Navas de la Concepción (Las)'), " +
                    " ( 41, 'Olivares'), " +
                    " ( 41, 'Osuna'), " +
                    " ( 41, 'Palacios y Villafranca (Los)'), " +
                    " ( 41, 'Palomares del Río'), " +
                    " ( 41, 'Paradas'), " +
                    " ( 41, 'Pedrera'), " +
                    " ( 41, 'Pedroso (El)'), " +
                    " ( 41, 'Peñaflor'), " +
                    " ( 41, 'Pilas'), " +
                    " ( 41, 'Pruna'), " +
                    " ( 41, 'Puebla de Cazalla (La)'), " +
                    " ( 41, 'Puebla de los Infantes (La)'), " +
                    " ( 41, 'Puebla del Río (La)'), " +
                    " ( 41, 'Real de la Jara (El)'), " +
                    " ( 41, 'Rinconada (La)'), " +
                    " ( 41, 'Roda de Andalucía (La)'), " +
                    " ( 41, 'Ronquillo (El)'), " +
                    " ( 41, 'Rubio (El)'), " +
                    " ( 41, 'Salteras'), " +
                    " ( 41, 'San Juan de Aznalfarache'), " +
                    " ( 41, 'San Nicolás del Puerto'), " +
                    " ( 41, 'Sanlúcar la Mayor'), " +
                    " ( 41, 'Santiponce'), " +
                    " ( 41, 'Saucejo (El)'), " +
                    " ( 41, 'Sevilla'), " +
                    " ( 41, 'Tocina'), " +
                    " ( 41, 'Tomares'), " +
                    " ( 41, 'Umbrete'), " +
                    " ( 41, 'Utrera'), " +
                    " ( 41, 'Valencina de la Concepción'), " +
                    " ( 41, 'Villamanrique de la Condesa'), " +
                    " ( 41, 'Villanueva de San Juan'), " +
                    " ( 41, 'Villanueva del Ariscal'), " +
                    " ( 41, 'Villanueva del Río y Minas'), " +
                    " ( 41, 'Villaverde del Río'), " +
                    " ( 41, 'Viso del Alcor (El)'), " +
                    " ( 42, 'Abejar'), " +
                    " ( 42, 'Adradas'), " +
                    " ( 42, 'Ágreda'), " +
                    " ( 42, 'Alconaba'), " +
                    " ( 42, 'Alcubilla de Avellaneda'), " +
                    " ( 42, 'Alcubilla de las Peñas'), " +
                    " ( 42, 'Aldealafuente'), " +
                    " ( 42, 'Aldealices'), " +
                    " ( 42, 'Aldealpozo'), " +
                    " ( 42, 'Aldealseñor'), " +
                    " ( 42, 'Aldehuela de Periáñez'), " +
                    " ( 42, 'Aldehuelas (Las)'), " +
                    " ( 42, 'Alentisque'), " +
                    " ( 42, 'Aliud'), " +
                    " ( 42, 'Almajano'), " +
                    " ( 42, 'Almaluez'), " +
                    " ( 42, 'Almarza'), " +
                    " ( 42, 'Almazán'), " +
                    " ( 42, 'Almazul'), " +
                    " ( 42, 'Almenar de Soria'), " +
                    " ( 42, 'Alpanseque'), " +
                    " ( 42, 'Arancón'), " +
                    " ( 42, 'Arcos de Jalón'), " +
                    " ( 42, 'Arenillas'), " +
                    " ( 42, 'Arévalo de la Sierra'), " +
                    " ( 42, 'Ausejo de la Sierra'), " +
                    " ( 42, 'Baraona'), " +
                    " ( 42, 'Barca'), " +
                    " ( 42, 'Barcones'), " +
                    " ( 42, 'Bayubas de Abajo'), " +
                    " ( 42, 'Bayubas de Arriba'), " +
                    " ( 42, 'Beratón'), " +
                    " ( 42, 'Berlanga de Duero'), " +
                    " ( 42, 'Blacos'), " +
                    " ( 42, 'Bliecos'), " +
                    " ( 42, 'Borjabad'), " +
                    " ( 42, 'Borobia'), " +
                    " ( 42, 'Buberos'), " +
                    " ( 42, 'Buitrago'), " +
                    " ( 42, 'Burgo de Osma-Ciudad de Osma'), " +
                    " ( 42, 'Cabrejas del Campo'), " +
                    " ( 42, 'Cabrejas del Pinar'), " +
                    " ( 42, 'Calatañazor'), " +
                    " ( 42, 'Caltojar'), " +
                    " ( 42, 'Candilichera'), " +
                    " ( 42, 'Cañamaque'), " +
                    " ( 42, 'Carabantes'), " +
                    " ( 42, 'Caracena'), " +
                    " ( 42, 'Carrascosa de Abajo'), " +
                    " ( 42, 'Carrascosa de la Sierra'), " +
                    " ( 42, 'Casarejos'), " +
                    " ( 42, 'Castilfrío de la Sierra'), " +
                    " ( 42, 'Castillejo de Robledo'), " +
                    " ( 42, 'Castilruiz'), " +
                    " ( 42, 'Centenera de Andaluz'), " +
                    " ( 42, 'Cerbón'), " +
                    " ( 42, 'Cidones'), " +
                    " ( 42, 'Cigudosa'), " +
                    " ( 42, 'Cihuela'), " +
                    " ( 42, 'Ciria'), " +
                    " ( 42, 'Cirujales del Río'), " +
                    " ( 42, 'Coscurita'), " +
                    " ( 42, 'Covaleda'), " +
                    " ( 42, 'Cubilla'), " +
                    " ( 42, 'Cubo de la Solana'), " +
                    " ( 42, 'Cueva de Ágreda'), " +
                    " ( 42, 'Dévanos'), " +
                    " ( 42, 'Deza'), " +
                    " ( 42, 'Duruelo de la Sierra'), " +
                    " ( 42, 'Escobosa de Almazán'), " +
                    " ( 42, 'Espeja de San Marcelino'), " +
                    " ( 42, 'Espejón'), " +
                    " ( 42, 'Estepa de San Juan'), " +
                    " ( 42, 'Frechilla de Almazán'), " +
                    " ( 42, 'Fresno de Caracena'), " +
                    " ( 42, 'Fuentearmegil'), " +
                    " ( 42, 'Fuentecambrón'), " +
                    " ( 42, 'Fuentecantos'), " +
                    " ( 42, 'Fuentelmonge'), " +
                    " ( 42, 'Fuentelsaz de Soria'), " +
                    " ( 42, 'Fuentepinilla'), " +
                    " ( 42, 'Fuentes de Magaña'), " +
                    " ( 42, 'Fuentestrún'), " +
                    " ( 42, 'Garray'), " +
                    " ( 42, 'Golmayo'), " +
                    " ( 42, 'Gómara'), " +
                    " ( 42, 'Gormaz'), " +
                    " ( 42, 'Herrera de Soria'), " +
                    " ( 42, 'Hinojosa del Campo'), " +
                    " ( 42, 'Langa de Duero'), " +
                    " ( 42, 'Liceras'), " +
                    " ( 42, 'Losilla (La)'), " +
                    " ( 42, 'Magaña'), " +
                    " ( 42, 'Maján'), " +
                    " ( 42, 'Matalebreras'), " +
                    " ( 42, 'Matamala de Almazán'), " +
                    " ( 42, 'Medinaceli'), " +
                    " ( 42, 'Miño de Medinaceli'), " +
                    " ( 42, 'Miño de San Esteban'), " +
                    " ( 42, 'Molinos de Duero'), " +
                    " ( 42, 'Momblona'), " +
                    " ( 42, 'Monteagudo de las Vicarías'), " +
                    " ( 42, 'Montejo de Tiermes'), " +
                    " ( 42, 'Montenegro de Cameros'), " +
                    " ( 42, 'Morón de Almazán'), " +
                    " ( 42, 'Muriel de la Fuente'), " +
                    " ( 42, 'Muriel Viejo'), " +
                    " ( 42, 'Nafría de Ucero'), " +
                    " ( 42, 'Narros'), " +
                    " ( 42, 'Navaleno'), " +
                    " ( 42, 'Nepas'), " +
                    " ( 42, 'Nolay'), " +
                    " ( 42, 'Noviercas'), " +
                    " ( 42, 'Ólvega'), " +
                    " ( 42, 'Oncala'), " +
                    " ( 42, 'Pinilla del Campo'), " +
                    " ( 42, 'Portillo de Soria'), " +
                    " ( 42, 'Póveda de Soria (La)'), " +
                    " ( 42, 'Pozalmuro'), " +
                    " ( 42, 'Quintana Redonda'), " +
                    " ( 42, 'Quintanas de Gormaz'), " +
                    " ( 42, 'Quiñonería'), " +
                    " ( 42, 'Rábanos (Los)'), " +
                    " ( 42, 'Rebollar (Soria)'), " +
                    " ( 42, 'Recuerda'), " +
                    " ( 42, 'Rello'), " +
                    " ( 42, 'Renieblas'), " +
                    " ( 42, 'Retortillo de Soria'), " +
                    " ( 42, 'Reznos'), " +
                    " ( 42, 'Riba de Escalote (La)'), " +
                    " ( 42, 'Rioseco de Soria'), " +
                    " ( 42, 'Rollamienta'), " +
                    " ( 42, 'Royo (El)'), " +
                    " ( 42, 'Salduero'), " +
                    " ( 42, 'San Esteban de Gormaz'), " +
                    " ( 42, 'San Felices'), " +
                    " ( 42, 'San Leonardo de Yagüe'), " +
                    " ( 42, 'San Pedro Manrique'), " +
                    " ( 42, 'Santa Cruz de Yanguas'), " +
                    " ( 42, 'Santa María de Huerta'), " +
                    " ( 42, 'Santa María de las Hoyas'), " +
                    " ( 42, 'Serón de Nágima'), " +
                    " ( 42, 'Soliedra'), " +
                    " ( 42, 'Soria'), " +
                    " ( 42, 'Sotillo del Rincón'), " +
                    " ( 42, 'Suellacabras'), " +
                    " ( 42, 'Tajahuerce'), " +
                    " ( 42, 'Tajueco'), " +
                    " ( 42, 'Talveila'), " +
                    " ( 42, 'Tardelcuende'), " +
                    " ( 42, 'Taroda'), " +
                    " ( 42, 'Tejado'), " +
                    " ( 42, 'Torlengua'), " +
                    " ( 42, 'Torreblacos'), " +
                    " ( 42, 'Torrubia de Soria'), " +
                    " ( 42, 'Trévago'), " +
                    " ( 42, 'Ucero'), " +
                    " ( 42, 'Vadillo'), " +
                    " ( 42, 'Valdeavellano de Tera'), " +
                    " ( 42, 'Valdegeña'), " +
                    " ( 42, 'Valdelagua del Cerro'), " +
                    " ( 42, 'Valdemaluque'), " +
                    " ( 42, 'Valdenebro'), " +
                    " ( 42, 'Valdeprado'), " +
                    " ( 42, 'Valderrodilla'), " +
                    " ( 42, 'Valtajeros'), " +
                    " ( 42, 'Velamazán'), " +
                    " ( 42, 'Velilla de la Sierra'), " +
                    " ( 42, 'Velilla de los Ajos'), " +
                    " ( 42, 'Viana de Duero'), " +
                    " ( 42, 'Villaciervos'), " +
                    " ( 42, 'Villanueva de Gormaz'), " +
                    " ( 42, 'Villar del Ala'), " +
                    " ( 42, 'Villar del Campo'), " +
                    " ( 42, 'Villar del Río'), " +
                    " ( 42, 'Villares de Soria (Los)'), " +
                    " ( 42, 'Villasayas'), " +
                    " ( 42, 'Villaseca de Arciel'), " +
                    " ( 42, 'Vinuesa'), " +
                    " ( 42, 'Vizmanos'), " +
                    " ( 42, 'Vozmediano'), " +
                    " ( 42, 'Yanguas'), " +
                    " ( 42, 'Yelo'), " +
                    " ( 43, 'Aiguamúrcia'), " +
                    " ( 43, 'Albinyana'), " +
                    " ( 43, 'Albiol (L'')'), " +
                    " ( 43, 'Alcanar'), " +
                    " ( 43, 'Alcover'), " +
                    " ( 43, 'Aldea (L'')'), " +
                    " ( 43, 'Aldover'), " +
                    " ( 43, 'Aleixar (L'')'), " +
                    " ( 43, 'Alfara de Carles'), " +
                    " ( 43, 'Alforja'), " +
                    " ( 43, 'Alió'), " +
                    " ( 43, 'Almoster'), " +
                    " ( 43, 'Altafulla'), " +
                    " ( 43, 'Ametlla de Mar (L'')'), " +
                    " ( 43, 'Ampolla (L'')'), " +
                    " ( 43, 'Amposta'), " +
                    " ( 43, 'Arboç (L'')'), " +
                    " ( 43, 'Arbolí'), " +
                    " ( 43, 'Argentera (L'')'), " +
                    " ( 43, 'Arnes'), " +
                    " ( 43, 'Ascó'), " +
                    " ( 43, 'Banyeres del Penedès'), " +
                    " ( 43, 'Barberà de la Conca'), " +
                    " ( 43, 'Batea'), " +
                    " ( 43, 'Bellmunt del Priorat'), " +
                    " ( 43, 'Bellvei'), " +
                    " ( 43, 'Benifallet'), " +
                    " ( 43, 'Benissanet'), " +
                    " ( 43, 'Bisbal de Falset (La)'), " +
                    " ( 43, 'Bisbal del Penedès (La)'), " +
                    " ( 43, 'Blancafort'), " +
                    " ( 43, 'Bonastre'), " +
                    " ( 43, 'Borges del Camp (Les)'), " +
                    " ( 43, 'Bot'), " +
                    " ( 43, 'Botarell'), " +
                    " ( 43, 'Bràfim'), " +
                    " ( 43, 'Cabacés'), " +
                    " ( 43, 'Cabra del Camp'), " +
                    " ( 43, 'Calafell'), " +
                    " ( 43, 'Camarles'), " +
                    " ( 43, 'Cambrils'), " +
                    " ( 43, 'Capafonts'), " +
                    " ( 43, 'Capçanes'), " +
                    " ( 43, 'Caseres'), " +
                    " ( 43, 'Castellvell del Camp'), " +
                    " ( 43, 'Catllar (El)'), " +
                    " ( 43, 'Colldejou'), " +
                    " ( 43, 'Conesa'), " +
                    " ( 43, 'Constantí'), " +
                    " ( 43, 'Corbera d''Ebre'), " +
                    " ( 43, 'Cornudella de Montsant'), " +
                    " ( 43, 'Creixell'), " +
                    " ( 43, 'Cunit'), " +
                    " ( 43, 'Deltebre'), " +
                    " ( 43, 'Duesaigües'), " +
                    " ( 43, 'Espluga de Francolí (L'')'), " +
                    " ( 43, 'Falset'), " +
                    " ( 43, 'Fatarella (La)'), " +
                    " ( 43, 'Febró (La)'), " +
                    " ( 43, 'Figuera (La)'), " +
                    " ( 43, 'Figuerola del Camp'), " +
                    " ( 43, 'Flix'), " +
                    " ( 43, 'Forès'), " +
                    " ( 43, 'Freginals'), " +
                    " ( 43, 'Galera (La)'), " +
                    " ( 43, 'Gandesa'), " +
                    " ( 43, 'Garcia'), " +
                    " ( 43, 'Garidells (Els)'), " +
                    " ( 43, 'Ginestar'), " +
                    " ( 43, 'Godall'), " +
                    " ( 43, 'Gratallops'), " +
                    " ( 43, 'Guiamets (Els)'), " +
                    " ( 43, 'Horta de Sant Joan'), " +
                    " ( 43, 'Lloar (El)'), " +
                    " ( 43, 'Llorac'), " +
                    " ( 43, 'Llorenç del Penedès'), " +
                    " ( 43, 'Marçà'), " +
                    " ( 43, 'Margalef'), " +
                    " ( 43, 'Mas de Barberans'), " +
                    " ( 43, 'Masdenverge'), " +
                    " ( 43, 'Masllorenç'), " +
                    " ( 43, 'Masó (La)'), " +
                    " ( 43, 'Maspujols'), " +
                    " ( 43, 'Masroig (El)'), " +
                    " ( 43, 'Milà (El)'), " +
                    " ( 43, 'Miravet'), " +
                    " ( 43, 'Molar (El) (Tarragona)'), " +
                    " ( 43, 'Montblanc'), " +
                    " ( 43, 'Montbrió del Camp'), " +
                    " ( 43, 'Montferri'), " +
                    " ( 43, 'Montmell (El)'), " +
                    " ( 43, 'Mont-ral'), " +
                    " ( 43, 'Mont-roig del Camp'), " +
                    " ( 43, 'Móra d''Ebre'), " +
                    " ( 43, 'Móra la Nova'), " +
                    " ( 43, 'Morell (El)'), " +
                    " ( 43, 'Morera de Montsant (La)'), " +
                    " ( 43, 'Nou de Gaià (La)'), " +
                    " ( 43, 'Nulles'), " +
                    " ( 43, 'Pallaresos (Els)'), " +
                    " ( 43, 'Palma d''Ebre (La)'), " +
                    " ( 43, 'Passanant i Belltall'), " +
                    " ( 43, 'Paüls'), " +
                    " ( 43, 'Perafort'), " +
                    " ( 43, 'Perelló (El)'), " +
                    " ( 43, 'Piles (Les)'), " +
                    " ( 43, 'Pinell de Brai (El)'), " +
                    " ( 43, 'Pira'), " +
                    " ( 43, 'Pla de Santa Maria (El)'), " +
                    " ( 43, 'Pobla de Mafumet (La)'), " +
                    " ( 43, 'Pobla de Massaluca (La)'), " +
                    " ( 43, 'Pobla de Montornès (La)'), " +
                    " ( 43, 'Poboleda'), " +
                    " ( 43, 'Pont d''Armentera (El)'), " +
                    " ( 43, 'Pontils'), " +
                    " ( 43, 'Porrera'), " +
                    " ( 43, 'Pradell de la Teixeta'), " +
                    " ( 43, 'Prades'), " +
                    " ( 43, 'Prat de Comte'), " +
                    " ( 43, 'Pratdip'), " +
                    " ( 43, 'Puigpelat'), " +
                    " ( 43, 'Querol'), " +
                    " ( 43, 'Rasquera'), " +
                    " ( 43, 'Renau'), " +
                    " ( 43, 'Reus'), " +
                    " ( 43, 'Riba (La)'), " +
                    " ( 43, 'Riba-roja d''Ebre'), " +
                    " ( 43, 'Riera de Gaià (La)'), " +
                    " ( 43, 'Riudecanyes'), " +
                    " ( 43, 'Riudecols'), " +
                    " ( 43, 'Riudoms'), " +
                    " ( 43, 'Rocafort de Queralt'), " +
                    " ( 43, 'Roda de Barà'), " +
                    " ( 43, 'Rodonyà'), " +
                    " ( 43, 'Roquetes'), " +
                    " ( 43, 'Rourell (El)'), " +
                    " ( 43, 'Salomó'), " +
                    " ( 43, 'Salou'), " +
                    " ( 43, 'Sant Carles de la Ràpita'), " +
                    " ( 43, 'Sant Jaume dels Domenys'), " +
                    " ( 43, 'Sant Jaume d''Enveja'), " +
                    " ( 43, 'Santa Bàrbara'), " +
                    " ( 43, 'Santa Coloma de Queralt'), " +
                    " ( 43, 'Santa Oliva'), " +
                    " ( 43, 'Sarral'), " +
                    " ( 43, 'Savallà del Comtat'), " +
                    " ( 43, 'Secuita (La)'), " +
                    " ( 43, 'Selva del Camp (La)'), " +
                    " ( 43, 'Senan'), " +
                    " ( 43, 'Sénia (La)'), " +
                    " ( 43, 'Solivella'), " +
                    " ( 43, 'Tarragona'), " +
                    " ( 43, 'Tivenys'), " +
                    " ( 43, 'Tivissa'), " +
                    " ( 43, 'Torre de Fontaubella (La)'), " +
                    " ( 43, 'Torre de l''Espanyol (La)'), " +
                    " ( 43, 'Torredembarra'), " +
                    " ( 43, 'Torroja del Priorat'), " +
                    " ( 43, 'Tortosa'), " +
                    " ( 43, 'Ulldecona'), " +
                    " ( 43, 'Ulldemolins'), " +
                    " ( 43, 'Vallclara'), " +
                    " ( 43, 'Vallfogona de Riucorb'), " +
                    " ( 43, 'Vallmoll'), " +
                    " ( 43, 'Valls'), " +
                    " ( 43, 'Vandellòs i l''Hospitalet de l''Infant'), " +
                    " ( 43, 'Vendrell (El)'), " +
                    " ( 43, 'Vespella de Gaià'), " +
                    " ( 43, 'Vilabella'), " +
                    " ( 43, 'Vilalba dels Arcs'), " +
                    " ( 43, 'Vilallonga del Camp'), " +
                    " ( 43, 'Vilanova de Prades'), " +
                    " ( 43, 'Vilanova d''Escornalbou'), " +
                    " ( 43, 'Vilaplana'), " +
                    " ( 43, 'Vila-rodona'), " +
                    " ( 43, 'Vila-seca'), " +
                    " ( 43, 'Vilaverd'), " +
                    " ( 43, 'Vilella Alta (La)'), " +
                    " ( 43, 'Vilella Baixa (La)'), " +
                    " ( 43, 'Vimbodí i Poblet'), " +
                    " ( 43, 'Vinebre'), " +
                    " ( 43, 'Vinyols i els Arcs'), " +
                    " ( 43, 'Xerta'), " +
                    " ( 44, 'Ababuj'), " +
                    " ( 44, 'Abejuela'), " +
                    " ( 44, 'Aguatón'), " +
                    " ( 44, 'Aguaviva'), " +
                    " ( 44, 'Aguilar del Alfambra'), " +
                    " ( 44, 'Alacón'), " +
                    " ( 44, 'Alba'), " +
                    " ( 44, 'Albalate del Arzobispo'), " +
                    " ( 44, 'Albarracín'), " +
                    " ( 44, 'Albentosa'), " +
                    " ( 44, 'Alcaine'), " +
                    " ( 44, 'Alcalá de la Selva'), " +
                    " ( 44, 'Alcañiz'), " +
                    " ( 44, 'Alcorisa'), " +
                    " ( 44, 'Alfambra'), " +
                    " ( 44, 'Aliaga'), " +
                    " ( 44, 'Allepuz'), " +
                    " ( 44, 'Alloza'), " +
                    " ( 44, 'Allueva'), " +
                    " ( 44, 'Almohaja'), " +
                    " ( 44, 'Alobras'), " +
                    " ( 44, 'Alpeñés'), " +
                    " ( 44, 'Anadón'), " +
                    " ( 44, 'Andorra'), " +
                    " ( 44, 'Arcos de las Salinas'), " +
                    " ( 44, 'Arens de Lledó'), " +
                    " ( 44, 'Argente'), " +
                    " ( 44, 'Ariño'), " +
                    " ( 44, 'Azaila'), " +
                    " ( 44, 'Bádenas'), " +
                    " ( 44, 'Báguena'), " +
                    " ( 44, 'Bañón'), " +
                    " ( 44, 'Barrachina'), " +
                    " ( 44, 'Bea'), " +
                    " ( 44, 'Beceite'), " +
                    " ( 44, 'Bello'), " +
                    " ( 44, 'Belmonte de San José'), " +
                    " ( 44, 'Berge'), " +
                    " ( 44, 'Bezas'), " +
                    " ( 44, 'Blancas'), " +
                    " ( 44, 'Blesa'), " +
                    " ( 44, 'Bordón'), " +
                    " ( 44, 'Bronchales'), " +
                    " ( 44, 'Bueña'), " +
                    " ( 44, 'Burbáguena'), " +
                    " ( 44, 'Cabra de Mora'), " +
                    " ( 44, 'Calaceite'), " +
                    " ( 44, 'Calamocha'), " +
                    " ( 44, 'Calanda'), " +
                    " ( 44, 'Calomarde'), " +
                    " ( 44, 'Camañas'), " +
                    " ( 44, 'Camarena de la Sierra'), " +
                    " ( 44, 'Camarillas'), " +
                    " ( 44, 'Caminreal'), " +
                    " ( 44, 'Cantavieja'), " +
                    " ( 44, 'Cañada de Benatanduz'), " +
                    " ( 44, 'Cañada de Verich (La)'), " +
                    " ( 44, 'Cañada Vellida'), " +
                    " ( 44, 'Cañizar del Olivar'), " +
                    " ( 44, 'Cascante del Río'), " +
                    " ( 44, 'Castejón de Tornos'), " +
                    " ( 44, 'Castel de Cabra'), " +
                    " ( 44, 'Castellar (El)'), " +
                    " ( 44, 'Castellote'), " +
                    " ( 44, 'Castelnou'), " +
                    " ( 44, 'Castelserás'), " +
                    " ( 44, 'Cedrillas'), " +
                    " ( 44, 'Celadas'), " +
                    " ( 44, 'Cella'), " +
                    " ( 44, 'Cerollera (La)'), " +
                    " ( 44, 'Codoñera (La)'), " +
                    " ( 44, 'Corbalán'), " +
                    " ( 44, 'Cortes de Aragón'), " +
                    " ( 44, 'Cosa'), " +
                    " ( 44, 'Cretas'), " +
                    " ( 44, 'Crivillén'), " +
                    " ( 44, 'Cuba (La)'), " +
                    " ( 44, 'Cubla'), " +
                    " ( 44, 'Cucalón'), " +
                    " ( 44, 'Cuervo (El)'), " +
                    " ( 44, 'Cuevas de Almudén'), " +
                    " ( 44, 'Cuevas Labradas'), " +
                    " ( 44, 'Ejulve'), " +
                    " ( 44, 'Escorihuela'), " +
                    " ( 44, 'Escucha'), " +
                    " ( 44, 'Estercuel'), " +
                    " ( 44, 'Ferreruela de Huerva'), " +
                    " ( 44, 'Fonfría'), " +
                    " ( 44, 'Formiche Alto'), " +
                    " ( 44, 'Fórnoles'), " +
                    " ( 44, 'Fortanete'), " +
                    " ( 44, 'Foz-Calanda'), " +
                    " ( 44, 'Fresneda (La)'), " +
                    " ( 44, 'Frías de Albarracín'), " +
                    " ( 44, 'Fuenferrada'), " +
                    " ( 44, 'Fuentes Calientes'), " +
                    " ( 44, 'Fuentes Claras'), " +
                    " ( 44, 'Fuentes de Rubielos'), " +
                    " ( 44, 'Fuentespalda'), " +
                    " ( 44, 'Galve'), " +
                    " ( 44, 'Gargallo'), " +
                    " ( 44, 'Gea de Albarracín'), " +
                    " ( 44, 'Ginebrosa (La)'), " +
                    " ( 44, 'Griegos'), " +
                    " ( 44, 'Guadalaviar'), " +
                    " ( 44, 'Gúdar'), " +
                    " ( 44, 'Híjar'), " +
                    " ( 44, 'Hinojosa de Jarque'), " +
                    " ( 44, 'Hoz de la Vieja (La)'), " +
                    " ( 44, 'Huesa del Común'), " +
                    " ( 44, 'Iglesuela del Cid (La)'), " +
                    " ( 44, 'Jabaloyas'), " +
                    " ( 44, 'Jarque de la Val'), " +
                    " ( 44, 'Jatiel'), " +
                    " ( 44, 'Jorcas'), " +
                    " ( 44, 'Josa'), " +
                    " ( 44, 'Lagueruela'), " +
                    " ( 44, 'Lanzuela'), " +
                    " ( 44, 'Libros'), " +
                    " ( 44, 'Lidón'), " +
                    " ( 44, 'Linares de Mora'), " +
                    " ( 44, 'Lledó'), " +
                    " ( 44, 'Loscos'), " +
                    " ( 44, 'Maicas'), " +
                    " ( 44, 'Manzanera'), " +
                    " ( 44, 'Martín del Río'), " +
                    " ( 44, 'Mas de las Matas'), " +
                    " ( 44, 'Mata de los Olmos (La)'), " +
                    " ( 44, 'Mazaleón'), " +
                    " ( 44, 'Mezquita de Jarque'), " +
                    " ( 44, 'Mirambel'), " +
                    " ( 44, 'Miravete de la Sierra'), " +
                    " ( 44, 'Molinos'), " +
                    " ( 44, 'Monforte de Moyuela'), " +
                    " ( 44, 'Monreal del Campo'), " +
                    " ( 44, 'Monroyo'), " +
                    " ( 44, 'Montalbán'), " +
                    " ( 44, 'Monteagudo del Castillo'), " +
                    " ( 44, 'Monterde de Albarracín'), " +
                    " ( 44, 'Mora de Rubielos'), " +
                    " ( 44, 'Moscardón'), " +
                    " ( 44, 'Mosqueruela'), " +
                    " ( 44, 'Muniesa'), " +
                    " ( 44, 'Noguera de Albarracín'), " +
                    " ( 44, 'Nogueras'), " +
                    " ( 44, 'Nogueruelas'), " +
                    " ( 44, 'Obón'), " +
                    " ( 44, 'Odón'), " +
                    " ( 44, 'Ojos Negros'), " +
                    " ( 44, 'Olba'), " +
                    " ( 44, 'Oliete'), " +
                    " ( 44, 'Olmos (Los)'), " +
                    " ( 44, 'Orihuela del Tremedal'), " +
                    " ( 44, 'Orrios'), " +
                    " ( 44, 'Palomar de Arroyos'), " +
                    " ( 44, 'Pancrudo'), " +
                    " ( 44, 'Parras de Castellote (Las)'), " +
                    " ( 44, 'Peñarroya de Tastavins'), " +
                    " ( 44, 'Peracense'), " +
                    " ( 44, 'Peralejos'), " +
                    " ( 44, 'Perales del Alfambra'), " +
                    " ( 44, 'Pitarque'), " +
                    " ( 44, 'Plou'), " +
                    " ( 44, 'Pobo (El)'), " +
                    " ( 44, 'Portellada (La)'), " +
                    " ( 44, 'Pozondón'), " +
                    " ( 44, 'Pozuel del Campo'), " +
                    " ( 44, 'Puebla de Híjar (La)'), " +
                    " ( 44, 'Puebla de Valverde (La)'), " +
                    " ( 44, 'Puertomingalvo'), " +
                    " ( 44, 'Ráfales'), " +
                    " ( 44, 'Rillo'), " +
                    " ( 44, 'Riodeva'), " +
                    " ( 44, 'Ródenas'), " +
                    " ( 44, 'Royuela'), " +
                    " ( 44, 'Rubiales'), " +
                    " ( 44, 'Rubielos de la Cérida'), " +
                    " ( 44, 'Rubielos de Mora'), " +
                    " ( 44, 'Salcedillo'), " +
                    " ( 44, 'Saldón'), " +
                    " ( 44, 'Samper de Calanda'), " +
                    " ( 44, 'San Agustín'), " +
                    " ( 44, 'San Martín del Río'), " +
                    " ( 44, 'Santa Cruz de Nogueras'), " +
                    " ( 44, 'Santa Eulalia'), " +
                    " ( 44, 'Sarrión'), " +
                    " ( 44, 'Segura de los Baños'), " +
                    " ( 44, 'Seno'), " +
                    " ( 44, 'Singra'), " +
                    " ( 44, 'Terriente'), " +
                    " ( 44, 'Teruel'), " +
                    " ( 44, 'Toril y Masegoso'), " +
                    " ( 44, 'Tormón'), " +
                    " ( 44, 'Tornos'), " +
                    " ( 44, 'Torralba de los Sisones'), " +
                    " ( 44, 'Torre de Arcas'), " +
                    " ( 44, 'Torre de las Arcas'), " +
                    " ( 44, 'Torre del Compte'), " +
                    " ( 44, 'Torre los Negros'), " +
                    " ( 44, 'Torrecilla de Alcañiz'), " +
                    " ( 44, 'Torrecilla del Rebollar'), " +
                    " ( 44, 'Torrelacárcel'), " +
                    " ( 44, 'Torremocha de Jiloca'), " +
                    " ( 44, 'Torres de Albarracín'), " +
                    " ( 44, 'Torrevelilla'), " +
                    " ( 44, 'Torrijas'), " +
                    " ( 44, 'Torrijo del Campo'), " +
                    " ( 44, 'Tramacastiel'), " +
                    " ( 44, 'Tramacastilla'), " +
                    " ( 44, 'Tronchón'), " +
                    " ( 44, 'Urrea de Gaén'), " +
                    " ( 44, 'Utrillas'), " +
                    " ( 44, 'Valacloche'), " +
                    " ( 44, 'Valbona'), " +
                    " ( 44, 'Valdealgorfa'), " +
                    " ( 44, 'Valdecuenca'), " +
                    " ( 44, 'Valdelinares'), " +
                    " ( 44, 'Valdeltormo'), " +
                    " ( 44, 'Valderrobres'), " +
                    " ( 44, 'Valjunquera'), " +
                    " ( 44, 'Vallecillo (El)'), " +
                    " ( 44, 'Veguillas de la Sierra'), " +
                    " ( 44, 'Villafranca del Campo'), " +
                    " ( 44, 'Villahermosa del Campo'), " +
                    " ( 44, 'Villanueva del Rebollar de la Sierra'), " +
                    " ( 44, 'Villar del Cobo'), " +
                    " ( 44, 'Villar del Salz'), " +
                    " ( 44, 'Villarluengo'), " +
                    " ( 44, 'Villarquemado'), " +
                    " ( 44, 'Villarroya de los Pinares'), " +
                    " ( 44, 'Villastar'), " +
                    " ( 44, 'Villel'), " +
                    " ( 44, 'Vinaceite'), " +
                    " ( 44, 'Visiedo'), " +
                    " ( 44, 'Vivel del Río Martín'), " +
                    " ( 44, 'Zoma (La)'), " +
                    " ( 45, 'Ajofrín'), " +
                    " ( 45, 'Alameda de la Sagra'), " +
                    " ( 45, 'Albarreal de Tajo'), " +
                    " ( 45, 'Alcabón'), " +
                    " ( 45, 'Alcañizo'), " +
                    " ( 45, 'Alcaudete de la Jara'), " +
                    " ( 45, 'Alcolea de Tajo'), " +
                    " ( 45, 'Aldea en Cabo'), " +
                    " ( 45, 'Aldeanueva de Barbarroya'), " +
                    " ( 45, 'Aldeanueva de San Bartolomé'), " +
                    " ( 45, 'Almendral de la Cañada'), " +
                    " ( 45, 'Almonacid de Toledo'), " +
                    " ( 45, 'Almorox'), " +
                    " ( 45, 'Añover de Tajo'), " +
                    " ( 45, 'Arcicóllar'), " +
                    " ( 45, 'Argés'), " +
                    " ( 45, 'Azután'), " +
                    " ( 45, 'Barcience'), " +
                    " ( 45, 'Bargas'), " +
                    " ( 45, 'Belvís de la Jara'), " +
                    " ( 45, 'Borox'), " +
                    " ( 45, 'Buenaventura'), " +
                    " ( 45, 'Burguillos de Toledo'), " +
                    " ( 45, 'Burujón'), " +
                    " ( 45, 'Cabañas de la Sagra'), " +
                    " ( 45, 'Cabañas de Yepes'), " +
                    " ( 45, 'Cabezamesada'), " +
                    " ( 45, 'Calera y Chozas'), " +
                    " ( 45, 'Caleruela'), " +
                    " ( 45, 'Calzada de Oropesa'), " +
                    " ( 45, 'Camarena'), " +
                    " ( 45, 'Camarenilla'), " +
                    " ( 45, 'Campillo de la Jara (El)'), " +
                    " ( 45, 'Camuñas'), " +
                    " ( 45, 'Cardiel de los Montes'), " +
                    " ( 45, 'Carmena'), " +
                    " ( 45, 'Carpio de Tajo (El)'), " +
                    " ( 45, 'Carranque'), " +
                    " ( 45, 'Carriches'), " +
                    " ( 45, 'Casar de Escalona (El)'), " +
                    " ( 45, 'Casarrubios del Monte'), " +
                    " ( 45, 'Casasbuenas'), " +
                    " ( 45, 'Castillo de Bayuela'), " +
                    " ( 45, 'Cazalegas'), " +
                    " ( 45, 'Cebolla'), " +
                    " ( 45, 'Cedillo del Condado'), " +
                    " ( 45, 'Cerralbos (Los)'), " +
                    " ( 45, 'Cervera de los Montes'), " +
                    " ( 45, 'Chozas de Canales'), " +
                    " ( 45, 'Chueca'), " +
                    " ( 45, 'Ciruelos'), " +
                    " ( 45, 'Cobeja'), " +
                    " ( 45, 'Cobisa'), " +
                    " ( 45, 'Consuegra'), " +
                    " ( 45, 'Corral de Almaguer'), " +
                    " ( 45, 'Cuerva'), " +
                    " ( 45, 'Domingo Pérez'), " +
                    " ( 45, 'Dosbarrios'), " +
                    " ( 45, 'Erustes'), " +
                    " ( 45, 'Escalona'), " +
                    " ( 45, 'Escalonilla'), " +
                    " ( 45, 'Espinoso del Rey'), " +
                    " ( 45, 'Esquivias'), " +
                    " ( 45, 'Estrella (La)'), " +
                    " ( 45, 'Fuensalida'), " +
                    " ( 45, 'Gálvez'), " +
                    " ( 45, 'Garciotum'), " +
                    " ( 45, 'Gerindote'), " +
                    " ( 45, 'Guadamur'), " +
                    " ( 45, 'Guardia (La)'), " +
                    " ( 45, 'Herencias (Las)'), " +
                    " ( 45, 'Herreruela de Oropesa'), " +
                    " ( 45, 'Hinojosa de San Vicente'), " +
                    " ( 45, 'Hontanar'), " +
                    " ( 45, 'Hormigos'), " +
                    " ( 45, 'Huecas'), " +
                    " ( 45, 'Huerta de Valdecarábanos'), " +
                    " ( 45, 'Iglesuela (La)'), " +
                    " ( 45, 'Illán de Vacas'), " +
                    " ( 45, 'Illescas'), " +
                    " ( 45, 'Lagartera'), " +
                    " ( 45, 'Layos'), " +
                    " ( 45, 'Lillo'), " +
                    " ( 45, 'Lominchar'), " +
                    " ( 45, 'Lucillos'), " +
                    " ( 45, 'Madridejos'), " +
                    " ( 45, 'Magán'), " +
                    " ( 45, 'Malpica de Tajo'), " +
                    " ( 45, 'Manzaneque'), " +
                    " ( 45, 'Maqueda'), " +
                    " ( 45, 'Marjaliza'), " +
                    " ( 45, 'Marrupe'), " +
                    " ( 45, 'Mascaraque'), " +
                    " ( 45, 'Mata (La)'), " +
                    " ( 45, 'Mazarambroz'), " +
                    " ( 45, 'Mejorada'), " +
                    " ( 45, 'Menasalbas'), " +
                    " ( 45, 'Méntrida'), " +
                    " ( 45, 'Mesegar de Tajo'), " +
                    " ( 45, 'Miguel Esteban'), " +
                    " ( 45, 'Mocejón'), " +
                    " ( 45, 'Mohedas de la Jara'), " +
                    " ( 45, 'Montearagón'), " +
                    " ( 45, 'Montesclaros'), " +
                    " ( 45, 'Mora'), " +
                    " ( 45, 'Nambroca'), " +
                    " ( 45, 'Nava de Ricomalillo (La)'), " +
                    " ( 45, 'Navahermosa'), " +
                    " ( 45, 'Navalcán'), " +
                    " ( 45, 'Navalmoralejo'), " +
                    " ( 45, 'Navalmorales (Los)'), " +
                    " ( 45, 'Navalucillos (Los)'), " +
                    " ( 45, 'Navamorcuende'), " +
                    " ( 45, 'Noblejas'), " +
                    " ( 45, 'Noez'), " +
                    " ( 45, 'Nombela'), " +
                    " ( 45, 'Novés'), " +
                    " ( 45, 'Numancia de la Sagra'), " +
                    " ( 45, 'Nuño Gómez'), " +
                    " ( 45, 'Ocaña'), " +
                    " ( 45, 'Olías del Rey'), " +
                    " ( 45, 'Ontígola'), " +
                    " ( 45, 'Orgaz'), " +
                    " ( 45, 'Oropesa'), " +
                    " ( 45, 'Otero'), " +
                    " ( 45, 'Palomeque'), " +
                    " ( 45, 'Pantoja'), " +
                    " ( 45, 'Paredes de Escalona'), " +
                    " ( 45, 'Parrillas'), " +
                    " ( 45, 'Pelahustán'), " +
                    " ( 45, 'Pepino'), " +
                    " ( 45, 'Polán'), " +
                    " ( 45, 'Portillo de Toledo'), " +
                    " ( 45, 'Puebla de Almoradiel (La)'), " +
                    " ( 45, 'Puebla de Montalbán (La)'), " +
                    " ( 45, 'Pueblanueva (La)'), " +
                    " ( 45, 'Puente del Arzobispo (El)'), " +
                    " ( 45, 'Puerto de San Vicente'), " +
                    " ( 45, 'Pulgar'), " +
                    " ( 45, 'Quero'), " +
                    " ( 45, 'Quintanar de la Orden'), " +
                    " ( 45, 'Quismondo'), " +
                    " ( 45, 'Real de San Vicente (El)'), " +
                    " ( 45, 'Recas'), " +
                    " ( 45, 'Retamoso de la Jara'), " +
                    " ( 45, 'Rielves'), " +
                    " ( 45, 'Robledo del Mazo'), " +
                    " ( 45, 'Romeral (El)'), " +
                    " ( 45, 'San Bartolomé de las Abiertas'), " +
                    " ( 45, 'San Martín de Montalbán'), " +
                    " ( 45, 'San Martín de Pusa'), " +
                    " ( 45, 'San Pablo de los Montes'), " +
                    " ( 45, 'San Román de los Montes'), " +
                    " ( 45, 'Santa Ana de Pusa'), " +
                    " ( 45, 'Santa Cruz de la Zarza'), " +
                    " ( 45, 'Santa Cruz del Retamar'), " +
                    " ( 45, 'Santa Olalla'), " +
                    " ( 45, 'Santo Domingo-Caudilla'), " +
                    " ( 45, 'Sartajada'), " +
                    " ( 45, 'Segurilla'), " +
                    " ( 45, 'Seseña'), " +
                    " ( 45, 'Sevilleja de la Jara'), " +
                    " ( 45, 'Sonseca'), " +
                    " ( 45, 'Sotillo de las Palomas'), " +
                    " ( 45, 'Talavera de la Reina'), " +
                    " ( 45, 'Tembleque'), " +
                    " ( 45, 'Toboso (El)'), " +
                    " ( 45, 'Toledo'), " +
                    " ( 45, 'Torralba de Oropesa'), " +
                    " ( 45, 'Torre de Esteban Hambrán (La)'), " +
                    " ( 45, 'Torrecilla de la Jara'), " +
                    " ( 45, 'Torrico'), " +
                    " ( 45, 'Torrijos'), " +
                    " ( 45, 'Totanés'), " +
                    " ( 45, 'Turleque'), " +
                    " ( 45, 'Ugena'), " +
                    " ( 45, 'Urda'), " +
                    " ( 45, 'Valdeverdeja'), " +
                    " ( 45, 'Valmojado'), " +
                    " ( 45, 'Velada'), " +
                    " ( 45, 'Ventas con Peña Aguilera (Las)'), " +
                    " ( 45, 'Ventas de Retamosa (Las)'), " +
                    " ( 45, 'Ventas de San Julián (Las)'), " +
                    " ( 45, 'Villa de Don Fadrique (La)'), " +
                    " ( 45, 'Villacañas'), " +
                    " ( 45, 'Villafranca de los Caballeros'), " +
                    " ( 45, 'Villaluenga de la Sagra'), " +
                    " ( 45, 'Villamiel de Toledo'), " +
                    " ( 45, 'Villaminaya'), " +
                    " ( 45, 'Villamuelas'), " +
                    " ( 45, 'Villanueva de Alcardete'), " +
                    " ( 45, 'Villanueva de Bogas'), " +
                    " ( 45, 'Villarejo de Montalbán'), " +
                    " ( 45, 'Villarrubia de Santiago'), " +
                    " ( 45, 'Villaseca de la Sagra'), " +
                    " ( 45, 'Villasequilla'), " +
                    " ( 45, 'Villatobas'), " +
                    " ( 45, 'Viso de San Juan (El)'), " +
                    " ( 45, 'Yébenes (Los)'), " +
                    " ( 45, 'Yeles'), " +
                    " ( 45, 'Yepes'), " +
                    " ( 45, 'Yuncler'), " +
                    " ( 45, 'Yunclillos'), " +
                    " ( 45, 'Yuncos'), " +
                    " ( 46, 'Ademuz'), " +
                    " ( 46, 'Ador'), " +
                    " ( 46, 'Agullent'), " +
                    " ( 46, 'Aielo de Malferit'), " +
                    " ( 46, 'Aielo de Rugat'), " +
                    " ( 46, 'Alaquàs'), " +
                    " ( 46, 'Albaida'), " +
                    " ( 46, 'Albal'), " +
                    " ( 46, 'Albalat de la Ribera'), " +
                    " ( 46, 'Albalat dels Sorells'), " +
                    " ( 46, 'Albalat dels Tarongers'), " +
                    " ( 46, 'Alberic'), " +
                    " ( 46, 'Alborache'), " +
                    " ( 46, 'Alboraya'), " +
                    " ( 46, 'Albuixech'), " +
                    " ( 46, 'Alcàntera de Xúquer'), " +
                    " ( 46, 'Alcàsser'), " +
                    " ( 46, 'Alcublas'), " +
                    " ( 46, 'Alcúdia (l'')'), " +
                    " ( 46, 'Alcúdia de Crespins (l'')'), " +
                    " ( 46, 'Aldaia'), " +
                    " ( 46, 'Alfafar'), " +
                    " ( 46, 'Alfara de Algimia'), " +
                    " ( 46, 'Alfara del Patriarca'), " +
                    " ( 46, 'Alfarp'), " +
                    " ( 46, 'Alfarrasí'), " +
                    " ( 46, 'Alfauir'), " +
                    " ( 46, 'Algar de Palancia'), " +
                    " ( 46, 'Algemesí'), " +
                    " ( 46, 'Algimia de Alfara'), " +
                    " ( 46, 'Alginet'), " +
                    " ( 46, 'Almàssera'), " +
                    " ( 46, 'Almiserà'), " +
                    " ( 46, 'Almoines'), " +
                    " ( 46, 'Almussafes'), " +
                    " ( 46, 'Alpuente'), " +
                    " ( 46, 'Alqueria de la Comtessa (l'')'), " +
                    " ( 46, 'Alzira'), " +
                    " ( 46, 'Andilla'), " +
                    " ( 46, 'Anna'), " +
                    " ( 46, 'Antella'), " +
                    " ( 46, 'Aras de los Olmos'), " +
                    " ( 46, 'Atzeneta d''Albaida'), " +
                    " ( 46, 'Ayora'), " +
                    " ( 46, 'Barx'), " +
                    " ( 46, 'Barxeta'), " +
                    " ( 46, 'Bèlgida'), " +
                    " ( 46, 'Bellreguard'), " +
                    " ( 46, 'Bellús'), " +
                    " ( 46, 'Benagéber'), " +
                    " ( 46, 'Benaguasil'), " +
                    " ( 46, 'Benavites'), " +
                    " ( 46, 'Beneixida'), " +
                    " ( 46, 'Benetússer'), " +
                    " ( 46, 'Beniarjó'), " +
                    " ( 46, 'Beniatjar'), " +
                    " ( 46, 'Benicolet'), " +
                    " ( 46, 'Benicull de Xúquer'), " +
                    " ( 46, 'Benifaió'), " +
                    " ( 46, 'Benifairó de la Valldigna'), " +
                    " ( 46, 'Benifairó de les Valls'), " +
                    " ( 46, 'Beniflá'), " +
                    " ( 46, 'Benigánim'), " +
                    " ( 46, 'Benimodo'), " +
                    " ( 46, 'Benimuslem'), " +
                    " ( 46, 'Beniparrell'), " +
                    " ( 46, 'Benirredrà'), " +
                    " ( 46, 'Benisanó'), " +
                    " ( 46, 'Benissoda'), " +
                    " ( 46, 'Benisuera'), " +
                    " ( 46, 'Bétera'), " +
                    " ( 46, 'Bicorp'), " +
                    " ( 46, 'Bocairent'), " +
                    " ( 46, 'Bolbaite'), " +
                    " ( 46, 'Bonrepòs i Mirambell'), " +
                    " ( 46, 'Bufali'), " +
                    " ( 46, 'Bugarra'), " +
                    " ( 46, 'Buñol'), " +
                    " ( 46, 'Burjassot'), " +
                    " ( 46, 'Calles'), " +
                    " ( 46, 'Camporrobles'), " +
                    " ( 46, 'Canals'), " +
                    " ( 46, 'Canet d''En Berenguer'), " +
                    " ( 46, 'Carcaixent'), " +
                    " ( 46, 'Càrcer'), " +
                    " ( 46, 'Carlet'), " +
                    " ( 46, 'Carrícola'), " +
                    " ( 46, 'Casas Altas'), " +
                    " ( 46, 'Casas Bajas'), " +
                    " ( 46, 'Casinos'), " +
                    " ( 46, 'Castelló de Rugat'), " +
                    " ( 46, 'Castellonet de la Conquesta'), " +
                    " ( 46, 'Castielfabib'), " +
                    " ( 46, 'Catadau'), " +
                    " ( 46, 'Catarroja'), " +
                    " ( 46, 'Caudete de las Fuentes'), " +
                    " ( 46, 'Cerdà'), " +
                    " ( 46, 'Chella'), " +
                    " ( 46, 'Chelva'), " +
                    " ( 46, 'Chera'), " +
                    " ( 46, 'Cheste'), " +
                    " ( 46, 'Chiva'), " +
                    " ( 46, 'Chulilla'), " +
                    " ( 46, 'Cofrentes'), " +
                    " ( 46, 'Corbera'), " +
                    " ( 46, 'Cortes de Pallás'), " +
                    " ( 46, 'Cotes'), " +
                    " ( 46, 'Cullera'), " +
                    " ( 46, 'Daimús'), " +
                    " ( 46, 'Domeño'), " +
                    " ( 46, 'Dos Aguas'), " +
                    " ( 46, 'Eliana (l'')'), " +
                    " ( 46, 'Emperador'), " +
                    " ( 46, 'Enguera'), " +
                    " ( 46, 'Ènova (l'')'), " +
                    " ( 46, 'Estivella'), " +
                    " ( 46, 'Estubeny'), " +
                    " ( 46, 'Faura'), " +
                    " ( 46, 'Favara'), " +
                    " ( 46, 'Foios'), " +
                    " ( 46, 'Font de la Figuera (la)'), " +
                    " ( 46, 'Font d''En Carròs (la)'), " +
                    " ( 46, 'Fontanars dels Alforins'), " +
                    " ( 46, 'Fortaleny'), " +
                    " ( 46, 'Fuenterrobles'), " +
                    " ( 46, 'Gandia'), " +
                    " ( 46, 'Gátova'), " +
                    " ( 46, 'Gavarda'), " +
                    " ( 46, 'Genovés'), " +
                    " ( 46, 'Gestalgar'), " +
                    " ( 46, 'Gilet'), " +
                    " ( 46, 'Godella'), " +
                    " ( 46, 'Godelleta'), " +
                    " ( 46, 'Granja de la Costera (la)'), " +
                    " ( 46, 'Guadasequies'), " +
                    " ( 46, 'Guadassuar'), " +
                    " ( 46, 'Guardamar de la Safor'), " +
                    " ( 46, 'Higueruelas'), " +
                    " ( 46, 'Jalance'), " +
                    " ( 46, 'Jarafuel'), " +
                    " ( 46, 'Llanera de Ranes'), " +
                    " ( 46, 'Llaurí'), " +
                    " ( 46, 'Llíria'), " +
                    " ( 46, 'Llocnou de la Corona'), " +
                    " ( 46, 'Llocnou de Sant Jeroni'), " +
                    " ( 46, 'Llocnou d''En Fenollet'), " +
                    " ( 46, 'Llombai'), " +
                    " ( 46, 'Llosa de Ranes (la)'), " +
                    " ( 46, 'Llutxent'), " +
                    " ( 46, 'Loriguilla'), " +
                    " ( 46, 'Losa del Obispo'), " +
                    " ( 46, 'Macastre'), " +
                    " ( 46, 'Manises'), " +
                    " ( 46, 'Manuel'), " +
                    " ( 46, 'Marines'), " +
                    " ( 46, 'Masalavés'), " +
                    " ( 46, 'Massalfassar'), " +
                    " ( 46, 'Massamagrell'), " +
                    " ( 46, 'Massanassa'), " +
                    " ( 46, 'Meliana'), " +
                    " ( 46, 'Millares'), " +
                    " ( 46, 'Miramar'), " +
                    " ( 46, 'Mislata'), " +
                    " ( 46, 'Mogente/Moixent'), " +
                    " ( 46, 'Moncada'), " +
                    " ( 46, 'Montaverner'), " +
                    " ( 46, 'Montesa'), " +
                    " ( 46, 'Montichelvo'), " +
                    " ( 46, 'Montroy'), " +
                    " ( 46, 'Montserrat'), " +
                    " ( 46, 'Museros'), " +
                    " ( 46, 'Náquera'), " +
                    " ( 46, 'Navarrés'), " +
                    " ( 46, 'Novelé/Novetlè'), " +
                    " ( 46, 'Oliva'), " +
                    " ( 46, 'Olleria (l'')'), " +
                    " ( 46, 'Olocau'), " +
                    " ( 46, 'Ontinyent'), " +
                    " ( 46, 'Otos'), " +
                    " ( 46, 'Paiporta'), " +
                    " ( 46, 'Palma de Gandía'), " +
                    " ( 46, 'Palmera'), " +
                    " ( 46, 'Palomar (el)'), " +
                    " ( 46, 'Paterna'), " +
                    " ( 46, 'Pedralba'), " +
                    " ( 46, 'Petrés'), " +
                    " ( 46, 'Picanya'), " +
                    " ( 46, 'Picassent'), " +
                    " ( 46, 'Piles'), " +
                    " ( 46, 'Pinet'), " +
                    " ( 46, 'Pobla de Farnals (la)'), " +
                    " ( 46, 'Pobla de Vallbona (la)'), " +
                    " ( 46, 'Pobla del Duc (la)'), " +
                    " ( 46, 'Pobla Llarga (la)'), " +
                    " ( 46, 'Polinyà de Xúquer'), " +
                    " ( 46, 'Potríes'), " +
                    " ( 46, 'Puçol'), " +
                    " ( 46, 'Puebla de San Miguel'), " +
                    " ( 46, 'Puig'), " +
                    " ( 46, 'Quart de les Valls'), " +
                    " ( 46, 'Quart de Poblet'), " +
                    " ( 46, 'Quartell'), " +
                    " ( 46, 'Quatretonda'), " +
                    " ( 46, 'Quesa'), " +
                    " ( 46, 'Rafelbuñol/Rafelbunyol'), " +
                    " ( 46, 'Rafelcofer'), " +
                    " ( 46, 'Rafelguaraf'), " +
                    " ( 46, 'Ráfol de Salem'), " +
                    " ( 46, 'Real de Gandía'), " +
                    " ( 46, 'Real de Montroi'), " +
                    " ( 46, 'Requena'), " +
                    " ( 46, 'Riba-roja de Túria'), " +
                    " ( 46, 'Riola'), " +
                    " ( 46, 'Rocafort'), " +
                    " ( 46, 'Rotglà i Corberà'), " +
                    " ( 46, 'Rótova'), " +
                    " ( 46, 'Rugat'), " +
                    " ( 46, 'Sagunto/Sagunt'), " +
                    " ( 46, 'Salem'), " +
                    " ( 46, 'San Antonio de Benagéber'), " +
                    " ( 46, 'San Juan de Énova'), " +
                    " ( 46, 'Sedaví'), " +
                    " ( 46, 'Segart'), " +
                    " ( 46, 'Sellent'), " +
                    " ( 46, 'Sempere'), " +
                    " ( 46, 'Senyera'), " +
                    " ( 46, 'Serra'), " +
                    " ( 46, 'Siete Aguas'), " +
                    " ( 46, 'Silla'), " +
                    " ( 46, 'Simat de la Valldigna'), " +
                    " ( 46, 'Sinarcas'), " +
                    " ( 46, 'Sollana'), " +
                    " ( 46, 'Sot de Chera'), " +
                    " ( 46, 'Sueca'), " +
                    " ( 46, 'Sumacàrcer'), " +
                    " ( 46, 'Tavernes Blanques'), " +
                    " ( 46, 'Tavernes de la Valldigna'), " +
                    " ( 46, 'Teresa de Cofrentes'), " +
                    " ( 46, 'Terrateig'), " +
                    " ( 46, 'Titaguas'), " +
                    " ( 46, 'Torrebaja'), " +
                    " ( 46, 'Torrella'), " +
                    " ( 46, 'Torrent (Valencia)'), " +
                    " ( 46, 'Torres Torres'), " +
                    " ( 46, 'Tous'), " +
                    " ( 46, 'Tuéjar'), " +
                    " ( 46, 'Turís'), " +
                    " ( 46, 'Utiel'), " +
                    " ( 46, 'Valencia'), " +
                    " ( 46, 'Vallada'), " +
                    " ( 46, 'Vallanca'), " +
                    " ( 46, 'Vallés'), " +
                    " ( 46, 'Venta del Moro'), " +
                    " ( 46, 'Vilamarxant'), " +
                    " ( 46, 'Villalonga'), " +
                    " ( 46, 'Villanueva de Castellón'), " +
                    " ( 46, 'Villar del Arzobispo'), " +
                    " ( 46, 'Villargordo del Cabriel'), " +
                    " ( 46, 'Vinalesa'), " +
                    " ( 46, 'Xàtiva'), " +
                    " ( 46, 'Xeraco'), " +
                    " ( 46, 'Xeresa'), " +
                    " ( 46, 'Xirivella'), " +
                    " ( 46, 'Yátova'), " +
                    " ( 46, 'Yesa (La)'), " +
                    " ( 46, 'Zarra'), " +
                    " ( 47, 'Adalia'), " +
                    " ( 47, 'Aguasal'), " +
                    " ( 47, 'Aguilar de Campos'), " +
                    " ( 47, 'Alaejos'), " +
                    " ( 47, 'Alcazarén'), " +
                    " ( 47, 'Aldea de San Miguel'), " +
                    " ( 47, 'Aldeamayor de San Martín'), " +
                    " ( 47, 'Almenara de Adaja'), " +
                    " ( 47, 'Amusquillo'), " +
                    " ( 47, 'Arroyo de la Encomienda'), " +
                    " ( 47, 'Ataquines'), " +
                    " ( 47, 'Bahabón'), " +
                    " ( 47, 'Barcial de la Loma'), " +
                    " ( 47, 'Barruelo del Valle'), " +
                    " ( 47, 'Becilla de Valderaduey'), " +
                    " ( 47, 'Benafarces'), " +
                    " ( 47, 'Bercero'), " +
                    " ( 47, 'Berceruelo'), " +
                    " ( 47, 'Berrueces'), " +
                    " ( 47, 'Bobadilla del Campo'), " +
                    " ( 47, 'Bocigas'), " +
                    " ( 47, 'Bocos de Duero'), " +
                    " ( 47, 'Boecillo'), " +
                    " ( 47, 'Bolaños de Campos'), " +
                    " ( 47, 'Brahojos de Medina'), " +
                    " ( 47, 'Bustillo de Chaves'), " +
                    " ( 47, 'Cabezón de Pisuerga'), " +
                    " ( 47, 'Cabezón de Valderaduey'), " +
                    " ( 47, 'Cabreros del Monte'), " +
                    " ( 47, 'Campaspero'), " +
                    " ( 47, 'Campillo (El) (Valladolid)'), " +
                    " ( 47, 'Camporredondo'), " +
                    " ( 47, 'Canalejas de Peñafiel'), " +
                    " ( 47, 'Canillas de Esgueva'), " +
                    " ( 47, 'Carpio'), " +
                    " ( 47, 'Casasola de Arión'), " +
                    " ( 47, 'Castrejón de Trabancos'), " +
                    " ( 47, 'Castrillo de Duero'), " +
                    " ( 47, 'Castrillo-Tejeriego'), " +
                    " ( 47, 'Castrobol'), " +
                    " ( 47, 'Castrodeza'), " +
                    " ( 47, 'Castromembibre'), " +
                    " ( 47, 'Castromonte'), " +
                    " ( 47, 'Castronuevo de Esgueva'), " +
                    " ( 47, 'Castronuño'), " +
                    " ( 47, 'Castroponce'), " +
                    " ( 47, 'Castroverde de Cerrato'), " +
                    " ( 47, 'Ceinos de Campos'), " +
                    " ( 47, 'Cervillego de la Cruz'), " +
                    " ( 47, 'Cigales'), " +
                    " ( 47, 'Ciguñuela'), " +
                    " ( 47, 'Cistérniga'), " +
                    " ( 47, 'Cogeces de Íscar'), " +
                    " ( 47, 'Cogeces del Monte'), " +
                    " ( 47, 'Corcos'), " +
                    " ( 47, 'Corrales de Duero'), " +
                    " ( 47, 'Cubillas de Santa Marta'), " +
                    " ( 47, 'Cuenca de Campos'), " +
                    " ( 47, 'Curiel de Duero'), " +
                    " ( 47, 'Encinas de Esgueva'), " +
                    " ( 47, 'Esguevillas de Esgueva'), " +
                    " ( 47, 'Fombellida'), " +
                    " ( 47, 'Fompedraza'), " +
                    " ( 47, 'Fontihoyuelo'), " +
                    " ( 47, 'Fresno el Viejo'), " +
                    " ( 47, 'Fuensaldaña'), " +
                    " ( 47, 'Fuente el Sol'), " +
                    " ( 47, 'Fuente-Olmedo'), " +
                    " ( 47, 'Gallegos de Hornija'), " +
                    " ( 47, 'Gatón de Campos'), " +
                    " ( 47, 'Geria'), " +
                    " ( 47, 'Herrín de Campos'), " +
                    " ( 47, 'Hornillos de Eresma'), " +
                    " ( 47, 'Íscar'), " +
                    " ( 47, 'Laguna de Duero'), " +
                    " ( 47, 'Langayo'), " +
                    " ( 47, 'Llano de Olmedo'), " +
                    " ( 47, 'Lomoviejo'), " +
                    " ( 47, 'Manzanillo'), " +
                    " ( 47, 'Marzales'), " +
                    " ( 47, 'Matapozuelos'), " +
                    " ( 47, 'Matilla de los Caños'), " +
                    " ( 47, 'Mayorga'), " +
                    " ( 47, 'Medina de Rioseco'), " +
                    " ( 47, 'Medina del Campo'), " +
                    " ( 47, 'Megeces'), " +
                    " ( 47, 'Melgar de Abajo'), " +
                    " ( 47, 'Melgar de Arriba'), " +
                    " ( 47, 'Mojados'), " +
                    " ( 47, 'Monasterio de Vega'), " +
                    " ( 47, 'Montealegre de Campos'), " +
                    " ( 47, 'Montemayor de Pililla'), " +
                    " ( 47, 'Moral de la Reina'), " +
                    " ( 47, 'Moraleja de las Panaderas'), " +
                    " ( 47, 'Morales de Campos'), " +
                    " ( 47, 'Mota del Marqués'), " +
                    " ( 47, 'Mucientes'), " +
                    " ( 47, 'Mudarra (La)'), " +
                    " ( 47, 'Muriel'), " +
                    " ( 47, 'Nava del Rey'), " +
                    " ( 47, 'Nueva Villa de las Torres'), " +
                    " ( 47, 'Olivares de Duero'), " +
                    " ( 47, 'Olmedo'), " +
                    " ( 47, 'Olmos de Esgueva'), " +
                    " ( 47, 'Olmos de Peñafiel'), " +
                    " ( 47, 'Palazuelo de Vedija'), " +
                    " ( 47, 'Parrilla (La)'), " +
                    " ( 47, 'Pedraja de Portillo (La)'), " +
                    " ( 47, 'Pedrajas de San Esteban'), " +
                    " ( 47, 'Pedrosa del Rey'), " +
                    " ( 47, 'Peñafiel'), " +
                    " ( 47, 'Peñaflor de Hornija'), " +
                    " ( 47, 'Pesquera de Duero'), " +
                    " ( 47, 'Piña de Esgueva'), " +
                    " ( 47, 'Piñel de Abajo'), " +
                    " ( 47, 'Piñel de Arriba'), " +
                    " ( 47, 'Pollos'), " +
                    " ( 47, 'Portillo'), " +
                    " ( 47, 'Pozal de Gallinas'), " +
                    " ( 47, 'Pozaldez'), " +
                    " ( 47, 'Pozuelo de la Orden'), " +
                    " ( 47, 'Puras'), " +
                    " ( 47, 'Quintanilla de Arriba'), " +
                    " ( 47, 'Quintanilla de Onésimo'), " +
                    " ( 47, 'Quintanilla de Trigueros'), " +
                    " ( 47, 'Quintanilla del Molar'), " +
                    " ( 47, 'Rábano'), " +
                    " ( 47, 'Ramiro'), " +
                    " ( 47, 'Renedo de Esgueva'), " +
                    " ( 47, 'Roales de Campos'), " +
                    " ( 47, 'Robladillo'), " +
                    " ( 47, 'Roturas'), " +
                    " ( 47, 'Rubí de Bracamonte'), " +
                    " ( 47, 'Rueda'), " +
                    " ( 47, 'Saelices de Mayorga'), " +
                    " ( 47, 'Salvador de Zapardiel'), " +
                    " ( 47, 'San Cebrián de Mazote'), " +
                    " ( 47, 'San Llorente'), " +
                    " ( 47, 'San Martín de Valvení'), " +
                    " ( 47, 'San Miguel del Arroyo'), " +
                    " ( 47, 'San Miguel del Pino'), " +
                    " ( 47, 'San Pablo de la Moraleja'), " +
                    " ( 47, 'San Pedro de Latarce'), " +
                    " ( 47, 'San Pelayo'), " +
                    " ( 47, 'San Román de Hornija'), " +
                    " ( 47, 'San Salvador'), " +
                    " ( 47, 'San Vicente del Palacio'), " +
                    " ( 47, 'Santa Eufemia del Arroyo'), " +
                    " ( 47, 'Santervás de Campos'), " +
                    " ( 47, 'Santibáñez de Valcorba'), " +
                    " ( 47, 'Santovenia de Pisuerga'), " +
                    " ( 47, 'Sardón de Duero'), " +
                    " ( 47, 'Seca (La)'), " +
                    " ( 47, 'Serrada'), " +
                    " ( 47, 'Siete Iglesias de Trabancos'), " +
                    " ( 47, 'Simancas'), " +
                    " ( 47, 'Tamariz de Campos'), " +
                    " ( 47, 'Tiedra'), " +
                    " ( 47, 'Tordehumos'), " +
                    " ( 47, 'Tordesillas'), " +
                    " ( 47, 'Torre de Esgueva'), " +
                    " ( 47, 'Torre de Peñafiel'), " +
                    " ( 47, 'Torrecilla de la Abadesa'), " +
                    " ( 47, 'Torrecilla de la Orden'), " +
                    " ( 47, 'Torrecilla de la Torre'), " +
                    " ( 47, 'Torrelobatón'), " +
                    " ( 47, 'Torrescárcela'), " +
                    " ( 47, 'Traspinedo'), " +
                    " ( 47, 'Trigueros del Valle'), " +
                    " ( 47, 'Tudela de Duero'), " +
                    " ( 47, 'Unión de Campos (La)'), " +
                    " ( 47, 'Urones de Castroponce'), " +
                    " ( 47, 'Urueña'), " +
                    " ( 47, 'Valbuena de Duero'), " +
                    " ( 47, 'Valdearcos de la Vega'), " +
                    " ( 47, 'Valdenebro de los Valles'), " +
                    " ( 47, 'Valdestillas'), " +
                    " ( 47, 'Valdunquillo'), " +
                    " ( 47, 'Valladolid'), " +
                    " ( 47, 'Valoria la Buena'), " +
                    " ( 47, 'Valverde de Campos'), " +
                    " ( 47, 'Vega de Ruiponce'), " +
                    " ( 47, 'Vega de Valdetronco'), " +
                    " ( 47, 'Velascálvaro'), " +
                    " ( 47, 'Velilla'), " +
                    " ( 47, 'Velliza'), " +
                    " ( 47, 'Ventosa de la Cuesta'), " +
                    " ( 47, 'Viana de Cega'), " +
                    " ( 47, 'Villabáñez'), " +
                    " ( 47, 'Villabaruz de Campos'), " +
                    " ( 47, 'Villabrágima'), " +
                    " ( 47, 'Villacarralón'), " +
                    " ( 47, 'Villacid de Campos'), " +
                    " ( 47, 'Villaco'), " +
                    " ( 47, 'Villafrades de Campos'), " +
                    " ( 47, 'Villafranca de Duero'), " +
                    " ( 47, 'Villafrechós'), " +
                    " ( 47, 'Villafuerte'), " +
                    " ( 47, 'Villagarcía de Campos'), " +
                    " ( 47, 'Villagómez la Nueva'), " +
                    " ( 47, 'Villalán de Campos'), " +
                    " ( 47, 'Villalar de los Comuneros'), " +
                    " ( 47, 'Villalba de la Loma'), " +
                    " ( 47, 'Villalba de los Alcores'), " +
                    " ( 47, 'Villalbarba'), " +
                    " ( 47, 'Villalón de Campos'), " +
                    " ( 47, 'Villamuriel de Campos'), " +
                    " ( 47, 'Villán de Tordesillas'), " +
                    " ( 47, 'Villanubla'), " +
                    " ( 47, 'Villanueva de Duero'), " +
                    " ( 47, 'Villanueva de la Condesa'), " +
                    " ( 47, 'Villanueva de los Caballeros'), " +
                    " ( 47, 'Villanueva de los Infantes (Valladolid)'), " +
                    " ( 47, 'Villanueva de San Mancio'), " +
                    " ( 47, 'Villardefrades'), " +
                    " ( 47, 'Villarmentero de Esgueva'), " +
                    " ( 47, 'Villasexmir'), " +
                    " ( 47, 'Villavaquerín'), " +
                    " ( 47, 'Villavellid'), " +
                    " ( 47, 'Villaverde de Medina'), " +
                    " ( 47, 'Villavicencio de los Caballeros'), " +
                    " ( 47, 'Viloria'), " +
                    " ( 47, 'Wamba'), " +
                    " ( 47, 'Zaratán'), " +
                    " ( 47, 'Zarza (La) (Valladolid)'), " +
                    " ( 48, 'Abadiño'), " +
                    " ( 48, 'Abanto y Ciérvana-Abanto Zierbena'), " +
                    " ( 48, 'Ajangiz'), " +
                    " ( 48, 'Alonsotegi'), " +
                    " ( 48, 'Amorebieta-Etxano'), " +
                    " ( 48, 'Amoroto'), " +
                    " ( 48, 'Arakaldo'), " +
                    " ( 48, 'Arantzazu'), " +
                    " ( 48, 'Areatza'), " +
                    " ( 48, 'Arrankudiaga'), " +
                    " ( 48, 'Arratzu'), " +
                    " ( 48, 'Arrieta'), " +
                    " ( 48, 'Arrigorriaga'), " +
                    " ( 48, 'Artea'), " +
                    " ( 48, 'Artzentales'), " +
                    " ( 48, 'Atxondo'), " +
                    " ( 48, 'Aulesti'), " +
                    " ( 48, 'Bakio'), " +
                    " ( 48, 'Balmaseda'), " +
                    " ( 48, 'Barakaldo'), " +
                    " ( 48, 'Barrika'), " +
                    " ( 48, 'Basauri'), " +
                    " ( 48, 'Bedia'), " +
                    " ( 48, 'Berango'), " +
                    " ( 48, 'Bermeo'), " +
                    " ( 48, 'Berriatua'), " +
                    " ( 48, 'Berriz'), " +
                    " ( 48, 'Bilbao'), " +
                    " ( 48, 'Busturia'), " +
                    " ( 48, 'Derio'), " +
                    " ( 48, 'Dima'), " +
                    " ( 48, 'Durango'), " +
                    " ( 48, 'Ea'), " +
                    " ( 48, 'Elantxobe'), " +
                    " ( 48, 'Elorrio'), " +
                    " ( 48, 'Erandio'), " +
                    " ( 48, 'Ereño'), " +
                    " ( 48, 'Ermua'), " +
                    " ( 48, 'Errigoiti'), " +
                    " ( 48, 'Etxebarri'), " +
                    " ( 48, 'Etxebarria'), " +
                    " ( 48, 'Forua'), " +
                    " ( 48, 'Fruiz'), " +
                    " ( 48, 'Galdakao'), " +
                    " ( 48, 'Galdames'), " +
                    " ( 48, 'Gamiz-Fika'), " +
                    " ( 48, 'Garai'), " +
                    " ( 48, 'Gatika'), " +
                    " ( 48, 'Gautegiz Arteaga'), " +
                    " ( 48, 'Gernika-Lumo'), " +
                    " ( 48, 'Getxo'), " +
                    " ( 48, 'Gizaburuaga'), " +
                    " ( 48, 'Gordexola'), " +
                    " ( 48, 'Gorliz'), " +
                    " ( 48, 'Güeñes'), " +
                    " ( 48, 'Ibarrangelu'), " +
                    " ( 48, 'Igorre'), " +
                    " ( 48, 'Ispaster'), " +
                    " ( 48, 'Iurreta'), " +
                    " ( 48, 'Izurtza'), " +
                    " ( 48, 'Karrantza Harana/Valle de Carranza'), " +
                    " ( 48, 'Kortezubi'), " +
                    " ( 48, 'Lanestosa'), " +
                    " ( 48, 'Larrabetzu'), " +
                    " ( 48, 'Laukiz'), " +
                    " ( 48, 'Leioa'), " +
                    " ( 48, 'Lekeitio'), " +
                    " ( 48, 'Lemoa'), " +
                    " ( 48, 'Lemoiz'), " +
                    " ( 48, 'Lezama'), " +
                    " ( 48, 'Loiu'), " +
                    " ( 48, 'Mallabia'), " +
                    " ( 48, 'Mañaria'), " +
                    " ( 48, 'Markina-Xemein'), " +
                    " ( 48, 'Maruri-Jatabe'), " +
                    " ( 48, 'Mendata'), " +
                    " ( 48, 'Mendexa'), " +
                    " ( 48, 'Meñaka'), " +
                    " ( 48, 'Morga'), " +
                    " ( 48, 'Mundaka'), " +
                    " ( 48, 'Mungia'), " +
                    " ( 48, 'Munitibar-Arbatzegi Gerrikaitz'), " +
                    " ( 48, 'Murueta'), " +
                    " ( 48, 'Muskiz'), " +
                    " ( 48, 'Muxika'), " +
                    " ( 48, 'Nabarniz'), " +
                    " ( 48, 'Ondarroa'), " +
                    " ( 48, 'Orozko'), " +
                    " ( 48, 'Ortuella'), " +
                    " ( 48, 'Otxandio'), " +
                    " ( 48, 'Plentzia'), " +
                    " ( 48, 'Portugalete'), " +
                    " ( 48, 'Santurtzi'), " +
                    " ( 48, 'Sestao'), " +
                    " ( 48, 'Sondika'), " +
                    " ( 48, 'Sopelana'), " +
                    " ( 48, 'Sopuerta'), " +
                    " ( 48, 'Sukarrieta'), " +
                    " ( 48, 'Trucios-Turtzioz'), " +
                    " ( 48, 'Ubide'), " +
                    " ( 48, 'Ugao-Miraballes'), " +
                    " ( 48, 'Urduliz'), " +
                    " ( 48, 'Urduña-Orduña'), " +
                    " ( 48, 'Valle de Trápaga-Trapagaran'), " +
                    " ( 48, 'Zaldibar'), " +
                    " ( 48, 'Zalla'), " +
                    " ( 48, 'Zamudio'), " +
                    " ( 48, 'Zaratamo'), " +
                    " ( 48, 'Zeanuri'), " +
                    " ( 48, 'Zeberio'), " +
                    " ( 48, 'Zierbena'), " +
                    " ( 48, 'Ziortza-Bolibar'), " +
                    " ( 49, 'Abezames'), " +
                    " ( 49, 'Alcañices'), " +
                    " ( 49, 'Alcubilla de Nogales'), " +
                    " ( 49, 'Alfaraz de Sayago'), " +
                    " ( 49, 'Algodre'), " +
                    " ( 49, 'Almaraz de Duero'), " +
                    " ( 49, 'Almeida de Sayago'), " +
                    " ( 49, 'Andavías'), " +
                    " ( 49, 'Arcenillas'), " +
                    " ( 49, 'Arcos de la Polvorosa'), " +
                    " ( 49, 'Argañín'), " +
                    " ( 49, 'Argujillo'), " +
                    " ( 49, 'Arquillinos'), " +
                    " ( 49, 'Arrabalde'), " +
                    " ( 49, 'Aspariegos'), " +
                    " ( 49, 'Asturianos'), " +
                    " ( 49, 'Ayoó de Vidriales'), " +
                    " ( 49, 'Barcial del Barco'), " +
                    " ( 49, 'Belver de los Montes'), " +
                    " ( 49, 'Benavente'), " +
                    " ( 49, 'Benegiles'), " +
                    " ( 49, 'Bermillo de Sayago'), " +
                    " ( 49, 'Bóveda de Toro (La)'), " +
                    " ( 49, 'Bretó'), " +
                    " ( 49, 'Bretocino'), " +
                    " ( 49, 'Brime de Sog'), " +
                    " ( 49, 'Brime de Urz'), " +
                    " ( 49, 'Burganes de Valverde'), " +
                    " ( 49, 'Bustillo del Oro'), " +
                    " ( 49, 'Cabañas de Sayago'), " +
                    " ( 49, 'Calzadilla de Tera'), " +
                    " ( 49, 'Camarzana de Tera'), " +
                    " ( 49, 'Cañizal'), " +
                    " ( 49, 'Cañizo'), " +
                    " ( 49, 'Carbajales de Alba'), " +
                    " ( 49, 'Carbellino'), " +
                    " ( 49, 'Casaseca de Campeán'), " +
                    " ( 49, 'Casaseca de las Chanas'), " +
                    " ( 49, 'Castrillo de la Guareña'), " +
                    " ( 49, 'Castrogonzalo'), " +
                    " ( 49, 'Castronuevo'), " +
                    " ( 49, 'Castroverde de Campos'), " +
                    " ( 49, 'Cazurra'), " +
                    " ( 49, 'Cerecinos de Campos'), " +
                    " ( 49, 'Cerecinos del Carrizal'), " +
                    " ( 49, 'Cernadilla'), " +
                    " ( 49, 'Cobreros'), " +
                    " ( 49, 'Coomonte'), " +
                    " ( 49, 'Coreses'), " +
                    " ( 49, 'Corrales'), " +
                    " ( 49, 'Cotanes del Monte'), " +
                    " ( 49, 'Cubillos'), " +
                    " ( 49, 'Cubo de Benavente'), " +
                    " ( 49, 'Cubo de Tierra del Vino (El)'), " +
                    " ( 49, 'Cuelgamures'), " +
                    " ( 49, 'Entrala'), " +
                    " ( 49, 'Espadañedo'), " +
                    " ( 49, 'Faramontanos de Tábara'), " +
                    " ( 49, 'Fariza'), " +
                    " ( 49, 'Fermoselle'), " +
                    " ( 49, 'Ferreras de Abajo'), " +
                    " ( 49, 'Ferreras de Arriba'), " +
                    " ( 49, 'Ferreruela'), " +
                    " ( 49, 'Figueruela de Arriba'), " +
                    " ( 49, 'Fonfría (Zamora)'), " +
                    " ( 49, 'Fresno de la Polvorosa'), " +
                    " ( 49, 'Fresno de la Ribera'), " +
                    " ( 49, 'Fresno de Sayago'), " +
                    " ( 49, 'Friera de Valverde'), " +
                    " ( 49, 'Fuente Encalada'), " +
                    " ( 49, 'Fuentelapeña'), " +
                    " ( 49, 'Fuentes de Ropel'), " +
                    " ( 49, 'Fuentesaúco'), " +
                    " ( 49, 'Fuentesecas'), " +
                    " ( 49, 'Fuentespreadas'), " +
                    " ( 49, 'Galende'), " +
                    " ( 49, 'Gallegos del Pan'), " +
                    " ( 49, 'Gallegos del Río'), " +
                    " ( 49, 'Gamones'), " +
                    " ( 49, 'Gema'), " +
                    " ( 49, 'Granja de Moreruela'), " +
                    " ( 49, 'Granucillo'), " +
                    " ( 49, 'Guarrate'), " +
                    " ( 49, 'Hermisende'), " +
                    " ( 49, 'Hiniesta (La)'), " +
                    " ( 49, 'Jambrina'), " +
                    " ( 49, 'Justel'), " +
                    " ( 49, 'Losacino'), " +
                    " ( 49, 'Losacio'), " +
                    " ( 49, 'Lubián'), " +
                    " ( 49, 'Luelmo'), " +
                    " ( 49, 'Maderal (El)'), " +
                    " ( 49, 'Madridanos'), " +
                    " ( 49, 'Mahide'), " +
                    " ( 49, 'Maire de Castroponce'), " +
                    " ( 49, 'Malva'), " +
                    " ( 49, 'Manganeses de la Lampreana'), " +
                    " ( 49, 'Manganeses de la Polvorosa'), " +
                    " ( 49, 'Manzanal de Arriba'), " +
                    " ( 49, 'Manzanal de los Infantes'), " +
                    " ( 49, 'Manzanal del Barco'), " +
                    " ( 49, 'Matilla de Arzón'), " +
                    " ( 49, 'Matilla la Seca'), " +
                    " ( 49, 'Mayalde'), " +
                    " ( 49, 'Melgar de Tera'), " +
                    " ( 49, 'Micereces de Tera'), " +
                    " ( 49, 'Milles de la Polvorosa'), " +
                    " ( 49, 'Molacillos'), " +
                    " ( 49, 'Molezuelas de la Carballeda'), " +
                    " ( 49, 'Mombuey'), " +
                    " ( 49, 'Monfarracinos'), " +
                    " ( 49, 'Montamarta'), " +
                    " ( 49, 'Moral de Sayago'), " +
                    " ( 49, 'Moraleja de Sayago'), " +
                    " ( 49, 'Moraleja del Vino'), " +
                    " ( 49, 'Morales de Rey'), " +
                    " ( 49, 'Morales de Toro'), " +
                    " ( 49, 'Morales de Valverde'), " +
                    " ( 49, 'Morales del Vino'), " +
                    " ( 49, 'Moralina'), " +
                    " ( 49, 'Moreruela de los Infanzones'), " +
                    " ( 49, 'Moreruela de Tábara'), " +
                    " ( 49, 'Muelas de los Caballeros'), " +
                    " ( 49, 'Muelas del Pan'), " +
                    " ( 49, 'Muga de Sayago'), " +
                    " ( 49, 'Navianos de Valverde'), " +
                    " ( 49, 'Olmillos de Castro'), " +
                    " ( 49, 'Otero de Bodas'), " +
                    " ( 49, 'Pajares de la Lampreana'), " +
                    " ( 49, 'Palacios de Sanabria'), " +
                    " ( 49, 'Palacios del Pan'), " +
                    " ( 49, 'Pedralba de la Pradería'), " +
                    " ( 49, 'Pego (El)'), " +
                    " ( 49, 'Peleagonzalo'), " +
                    " ( 49, 'Peleas de Abajo'), " +
                    " ( 49, 'Peñausende'), " +
                    " ( 49, 'Peque'), " +
                    " ( 49, 'Perdigón (El)'), " +
                    " ( 49, 'Pereruela'), " +
                    " ( 49, 'Perilla de Castro'), " +
                    " ( 49, 'Pías'), " +
                    " ( 49, 'Piedrahita de Castro'), " +
                    " ( 49, 'Pinilla de Toro'), " +
                    " ( 49, 'Pino del Oro'), " +
                    " ( 49, 'Piñero (El)'), " +
                    " ( 49, 'Pobladura de Valderaduey'), " +
                    " ( 49, 'Pobladura del Valle'), " +
                    " ( 49, 'Porto'), " +
                    " ( 49, 'Pozoantiguo'), " +
                    " ( 49, 'Pozuelo de Tábara'), " +
                    " ( 49, 'Prado'), " +
                    " ( 49, 'Puebla de Sanabria'), " +
                    " ( 49, 'Pueblica de Valverde'), " +
                    " ( 49, 'Quintanilla de Urz'), " +
                    " ( 49, 'Quintanilla del Monte'), " +
                    " ( 49, 'Quintanilla del Olmo'), " +
                    " ( 49, 'Quiruelas de Vidriales'), " +
                    " ( 49, 'Rabanales'), " +
                    " ( 49, 'Rábano de Aliste'), " +
                    " ( 49, 'Requejo'), " +
                    " ( 49, 'Revellinos'), " +
                    " ( 49, 'Riofrío de Aliste'), " +
                    " ( 49, 'Rionegro del Puente'), " +
                    " ( 49, 'Roales'), " +
                    " ( 49, 'Robleda-Cervantes'), " +
                    " ( 49, 'Roelos de Sayago'), " +
                    " ( 49, 'Rosinos de la Requejada'), " +
                    " ( 49, 'Salce'), " +
                    " ( 49, 'Samir de los Caños'), " +
                    " ( 49, 'San Agustín del Pozo'), " +
                    " ( 49, 'San Cebrián de Castro'), " +
                    " ( 49, 'San Cristóbal de Entreviñas'), " +
                    " ( 49, 'San Esteban del Molar'), " +
                    " ( 49, 'San Justo'), " +
                    " ( 49, 'San Martín de Valderaduey'), " +
                    " ( 49, 'San Miguel de la Ribera'), " +
                    " ( 49, 'San Miguel del Valle'), " +
                    " ( 49, 'San Pedro de Ceque'), " +
                    " ( 49, 'San Pedro de la Nave-Almendra'), " +
                    " ( 49, 'San Vicente de la Cabeza'), " +
                    " ( 49, 'San Vitero'), " +
                    " ( 49, 'Santa Clara de Avedillo'), " +
                    " ( 49, 'Santa Colomba de las Monjas'), " +
                    " ( 49, 'Santa Cristina de la Polvorosa'), " +
                    " ( 49, 'Santa Croya de Tera'), " +
                    " ( 49, 'Santa Eufemia del Barco'), " +
                    " ( 49, 'Santa María de la Vega'), " +
                    " ( 49, 'Santa María de Valverde'), " +
                    " ( 49, 'Santibáñez de Tera'), " +
                    " ( 49, 'Santibáñez de Vidriales'), " +
                    " ( 49, 'Santovenia'), " +
                    " ( 49, 'Sanzoles'), " +
                    " ( 49, 'Tábara'), " +
                    " ( 49, 'Tapioles'), " +
                    " ( 49, 'Toro'), " +
                    " ( 49, 'Torre del Valle (La)'), " +
                    " ( 49, 'Torregamones'), " +
                    " ( 49, 'Torres del Carrizal'), " +
                    " ( 49, 'Trabazos'), " +
                    " ( 49, 'Trefacio'), " +
                    " ( 49, 'Uña de Quintana'), " +
                    " ( 49, 'Vadillo de la Guareña'), " +
                    " ( 49, 'Valcabado'), " +
                    " ( 49, 'Valdefinjas'), " +
                    " ( 49, 'Valdescorriel'), " +
                    " ( 49, 'Vallesa de la Guareña'), " +
                    " ( 49, 'Vega de Tera'), " +
                    " ( 49, 'Vega de Villalobos'), " +
                    " ( 49, 'Vegalatrave'), " +
                    " ( 49, 'Venialbo'), " +
                    " ( 49, 'Vezdemarbán'), " +
                    " ( 49, 'Vidayanes'), " +
                    " ( 49, 'Videmala'), " +
                    " ( 49, 'Villabrázaro'), " +
                    " ( 49, 'Villabuena del Puente'), " +
                    " ( 49, 'Villadepera'), " +
                    " ( 49, 'Villaescusa (Zamora)'), " +
                    " ( 49, 'Villafáfila'), " +
                    " ( 49, 'Villaferrueña'), " +
                    " ( 49, 'Villageriz'), " +
                    " ( 49, 'Villalazán'), " +
                    " ( 49, 'Villalba de la Lampreana'), " +
                    " ( 49, 'Villalcampo'), " +
                    " ( 49, 'Villalobos'), " +
                    " ( 49, 'Villalonso'), " +
                    " ( 49, 'Villalpando'), " +
                    " ( 49, 'Villalube'), " +
                    " ( 49, 'Villamayor de Campos'), " +
                    " ( 49, 'Villamor de los Escuderos'), " +
                    " ( 49, 'Villanázar'), " +
                    " ( 49, 'Villanueva de Azoague'), " +
                    " ( 49, 'Villanueva de Campeán'), " +
                    " ( 49, 'Villanueva de las Peras'), " +
                    " ( 49, 'Villanueva del Campo'), " +
                    " ( 49, 'Villar de Fallaves'), " +
                    " ( 49, 'Villar del Buey'), " +
                    " ( 49, 'Villaralbo'), " +
                    " ( 49, 'Villardeciervos'), " +
                    " ( 49, 'Villardiegua de la Ribera'), " +
                    " ( 49, 'Villárdiga'), " +
                    " ( 49, 'Villardondiego'), " +
                    " ( 49, 'Villarrín de Campos'), " +
                    " ( 49, 'Villaseco del Pan'), " +
                    " ( 49, 'Villavendimio'), " +
                    " ( 49, 'Villaveza de Valverde'), " +
                    " ( 49, 'Villaveza del Agua'), " +
                    " ( 49, 'Viñas'), " +
                    " ( 49, 'Zamora'), " +
                    " ( 50, 'Abanto'), " +
                    " ( 50, 'Acered'), " +
                    " ( 50, 'Agón'), " +
                    " ( 50, 'Aguarón'), " +
                    " ( 50, 'Aguilón'), " +
                    " ( 50, 'Ainzón'), " +
                    " ( 50, 'Aladrén'), " +
                    " ( 50, 'Alagón'), " +
                    " ( 50, 'Alarba'), " +
                    " ( 50, 'Alberite de San Juan'), " +
                    " ( 50, 'Albeta'), " +
                    " ( 50, 'Alborge'), " +
                    " ( 50, 'Alcalá de Ebro'), " +
                    " ( 50, 'Alcalá de Moncayo'), " +
                    " ( 50, 'Alconchel de Ariza'), " +
                    " ( 50, 'Aldehuela de Liestos'), " +
                    " ( 50, 'Alfajarín'), " +
                    " ( 50, 'Alfamén'), " +
                    " ( 50, 'Alforque'), " +
                    " ( 50, 'Alhama de Aragón'), " +
                    " ( 50, 'Almochuel'), " +
                    " ( 50, 'Almolda (La)'), " +
                    " ( 50, 'Almonacid de la Cuba'), " +
                    " ( 50, 'Almonacid de la Sierra'), " +
                    " ( 50, 'Almunia de Doña Godina (La)'), " +
                    " ( 50, 'Alpartir'), " +
                    " ( 50, 'Ambel'), " +
                    " ( 50, 'Anento'), " +
                    " ( 50, 'Aniñón'), " +
                    " ( 50, 'Añón de Moncayo'), " +
                    " ( 50, 'Aranda de Moncayo'), " +
                    " ( 50, 'Arándiga'), " +
                    " ( 50, 'Ardisa'), " +
                    " ( 50, 'Ariza'), " +
                    " ( 50, 'Artieda'), " +
                    " ( 50, 'Asín'), " +
                    " ( 50, 'Atea'), " +
                    " ( 50, 'Ateca'), " +
                    " ( 50, 'Azuara'), " +
                    " ( 50, 'Badules'), " +
                    " ( 50, 'Bagüés'), " +
                    " ( 50, 'Balconchán'), " +
                    " ( 50, 'Bárboles'), " +
                    " ( 50, 'Bardallur'), " +
                    " ( 50, 'Belchite'), " +
                    " ( 50, 'Belmonte de Gracián'), " +
                    " ( 50, 'Berdejo'), " +
                    " ( 50, 'Berrueco'), " +
                    " ( 50, 'Biel'), " +
                    " ( 50, 'Bijuesca'), " +
                    " ( 50, 'Biota'), " +
                    " ( 50, 'Bisimbre'), " +
                    " ( 50, 'Boquiñeni'), " +
                    " ( 50, 'Bordalba'), " +
                    " ( 50, 'Borja'), " +
                    " ( 50, 'Botorrita'), " +
                    " ( 50, 'Brea de Aragón'), " +
                    " ( 50, 'Bubierca'), " +
                    " ( 50, 'Bujaraloz'), " +
                    " ( 50, 'Bulbuente'), " +
                    " ( 50, 'Bureta'), " +
                    " ( 50, 'Burgo de Ebro (El)'), " +
                    " ( 50, 'Buste (El)'), " +
                    " ( 50, 'Cabañas de Ebro'), " +
                    " ( 50, 'Cabolafuente'), " +
                    " ( 50, 'Cadrete'), " +
                    " ( 50, 'Calatayud'), " +
                    " ( 50, 'Calatorao'), " +
                    " ( 50, 'Calcena'), " +
                    " ( 50, 'Calmarza'), " +
                    " ( 50, 'Campillo de Aragón'), " +
                    " ( 50, 'Carenas'), " +
                    " ( 50, 'Cariñena'), " +
                    " ( 50, 'Caspe'), " +
                    " ( 50, 'Castejón de Alarba'), " +
                    " ( 50, 'Castejón de las Armas'), " +
                    " ( 50, 'Castejón de Valdejasa'), " +
                    " ( 50, 'Castiliscar'), " +
                    " ( 50, 'Cervera de la Cañada'), " +
                    " ( 50, 'Cerveruela'), " +
                    " ( 50, 'Cetina'), " +
                    " ( 50, 'Chiprana'), " +
                    " ( 50, 'Chodes'), " +
                    " ( 50, 'Cimballa'), " +
                    " ( 50, 'Cinco Olivas'), " +
                    " ( 50, 'Clarés de Ribota'), " +
                    " ( 50, 'Codo'), " +
                    " ( 50, 'Codos'), " +
                    " ( 50, 'Contamina'), " +
                    " ( 50, 'Cosuenda'), " +
                    " ( 50, 'Cuarte de Huerva'), " +
                    " ( 50, 'Cubel'), " +
                    " ( 50, 'Cuerlas (Las)'), " +
                    " ( 50, 'Daroca'), " +
                    " ( 50, 'Ejea de los Caballeros'), " +
                    " ( 50, 'Embid de Ariza'), " +
                    " ( 50, 'Encinacorba'), " +
                    " ( 50, 'Épila'), " +
                    " ( 50, 'Erla'), " +
                    " ( 50, 'Escatrón'), " +
                    " ( 50, 'Fabara'), " +
                    " ( 50, 'Farlete'), " +
                    " ( 50, 'Fayón'), " +
                    " ( 50, 'Fayos (Los)'), " +
                    " ( 50, 'Figueruelas'), " +
                    " ( 50, 'Fombuena'), " +
                    " ( 50, 'Frago (El)'), " +
                    " ( 50, 'Frasno (El)'), " +
                    " ( 50, 'Fréscano'), " +
                    " ( 50, 'Fuendejalón'), " +
                    " ( 50, 'Fuendetodos'), " +
                    " ( 50, 'Fuentes de Ebro'), " +
                    " ( 50, 'Fuentes de Jiloca'), " +
                    " ( 50, 'Gallocanta'), " +
                    " ( 50, 'Gallur'), " +
                    " ( 50, 'Gelsa'), " +
                    " ( 50, 'Godojos'), " +
                    " ( 50, 'Gotor'), " +
                    " ( 50, 'Grisel'), " +
                    " ( 50, 'Grisén'), " +
                    " ( 50, 'Herrera de los Navarros'), " +
                    " ( 50, 'Ibdes'), " +
                    " ( 50, 'Illueca'), " +
                    " ( 50, 'Isuerre'), " +
                    " ( 50, 'Jaraba'), " +
                    " ( 50, 'Jarque'), " +
                    " ( 50, 'Jaulín'), " +
                    " ( 50, 'Joyosa (La)'), " +
                    " ( 50, 'Lagata'), " +
                    " ( 50, 'Langa del Castillo'), " +
                    " ( 50, 'Layana'), " +
                    " ( 50, 'Lécera'), " +
                    " ( 50, 'Lechón'), " +
                    " ( 50, 'Leciñena'), " +
                    " ( 50, 'Letux'), " +
                    " ( 50, 'Litago'), " +
                    " ( 50, 'Lituénigo'), " +
                    " ( 50, 'Lobera de Onsella'), " +
                    " ( 50, 'Longares'), " +
                    " ( 50, 'Longás'), " +
                    " ( 50, 'Lucena de Jalón'), " +
                    " ( 50, 'Luceni'), " +
                    " ( 50, 'Luesia'), " +
                    " ( 50, 'Luesma'), " +
                    " ( 50, 'Lumpiaque'), " +
                    " ( 50, 'Luna'), " +
                    " ( 50, 'Maella'), " +
                    " ( 50, 'Magallón'), " +
                    " ( 50, 'Mainar'), " +
                    " ( 50, 'Malanquilla'), " +
                    " ( 50, 'Maleján'), " +
                    " ( 50, 'Mallén'), " +
                    " ( 50, 'Malón'), " +
                    " ( 50, 'Maluenda'), " +
                    " ( 50, 'Manchones'), " +
                    " ( 50, 'Mara'), " +
                    " ( 50, 'María de Huerva'), " +
                    " ( 50, 'Marracos'), " +
                    " ( 50, 'Mediana de Aragón'), " +
                    " ( 50, 'Mequinenza'), " +
                    " ( 50, 'Mesones de Isuela'), " +
                    " ( 50, 'Mezalocha'), " +
                    " ( 50, 'Mianos'), " +
                    " ( 50, 'Miedes de Aragón'), " +
                    " ( 50, 'Monegrillo'), " +
                    " ( 50, 'Moneva'), " +
                    " ( 50, 'Monreal de Ariza'), " +
                    " ( 50, 'Monterde'), " +
                    " ( 50, 'Montón'), " +
                    " ( 50, 'Morata de Jalón'), " +
                    " ( 50, 'Morata de Jiloca'), " +
                    " ( 50, 'Morés'), " +
                    " ( 50, 'Moros'), " +
                    " ( 50, 'Moyuela'), " +
                    " ( 50, 'Mozota'), " +
                    " ( 50, 'Muel'), " +
                    " ( 50, 'Muela (La)'), " +
                    " ( 50, 'Munébrega'), " +
                    " ( 50, 'Murero'), " +
                    " ( 50, 'Murillo de Gállego'), " +
                    " ( 50, 'Navardún'), " +
                    " ( 50, 'Nigüella'), " +
                    " ( 50, 'Nombrevilla'), " +
                    " ( 50, 'Nonaspe'), " +
                    " ( 50, 'Novallas'), " +
                    " ( 50, 'Novillas'), " +
                    " ( 50, 'Nuévalos'), " +
                    " ( 50, 'Nuez de Ebro'), " +
                    " ( 50, 'Olvés'), " +
                    " ( 50, 'Orcajo'), " +
                    " ( 50, 'Orera'), " +
                    " ( 50, 'Orés'), " +
                    " ( 50, 'Oseja'), " +
                    " ( 50, 'Osera de Ebro'), " +
                    " ( 50, 'Paniza'), " +
                    " ( 50, 'Paracuellos de Jiloca'), " +
                    " ( 50, 'Paracuellos de la Ribera'), " +
                    " ( 50, 'Pastriz'), " +
                    " ( 50, 'Pedrola'), " +
                    " ( 50, 'Pedrosas (Las)'), " +
                    " ( 50, 'Perdiguera'), " +
                    " ( 50, 'Piedratajada'), " +
                    " ( 50, 'Pina de Ebro'), " +
                    " ( 50, 'Pinseque'), " +
                    " ( 50, 'Pintanos (Los)'), " +
                    " ( 50, 'Plasencia de Jalón'), " +
                    " ( 50, 'Pleitas'), " +
                    " ( 50, 'Plenas'), " +
                    " ( 50, 'Pomer'), " +
                    " ( 50, 'Pozuel de Ariza'), " +
                    " ( 50, 'Pozuelo de Aragón'), " +
                    " ( 50, 'Pradilla de Ebro'), " +
                    " ( 50, 'Puebla de Albortón'), " +
                    " ( 50, 'Puebla de Alfindén (La)'), " +
                    " ( 50, 'Puendeluna'), " +
                    " ( 50, 'Purujosa'), " +
                    " ( 50, 'Quinto'), " +
                    " ( 50, 'Remolinos'), " +
                    " ( 50, 'Retascón'), " +
                    " ( 50, 'Ricla'), " +
                    " ( 50, 'Romanos'), " +
                    " ( 50, 'Rueda de Jalón'), " +
                    " ( 50, 'Ruesca'), " +
                    " ( 50, 'Sabiñán'), " +
                    " ( 50, 'Sádaba'), " +
                    " ( 50, 'Salillas de Jalón'), " +
                    " ( 50, 'Salvatierra de Esca'), " +
                    " ( 50, 'Samper del Salz'), " +
                    " ( 50, 'San Martín de la Virgen de Moncayo'), " +
                    " ( 50, 'San Mateo de Gállego'), " +
                    " ( 50, 'Santa Cruz de Grío'), " +
                    " ( 50, 'Santa Cruz de Moncayo'), " +
                    " ( 50, 'Santa Eulalia de Gállego'), " +
                    " ( 50, 'Santed'), " +
                    " ( 50, 'Sástago'), " +
                    " ( 50, 'Sediles'), " +
                    " ( 50, 'Sestrica'), " +
                    " ( 50, 'Sierra de Luna'), " +
                    " ( 50, 'Sigüés'), " +
                    " ( 50, 'Sisamón'), " +
                    " ( 50, 'Sobradiel'), " +
                    " ( 50, 'Sos del Rey Católico'), " +
                    " ( 50, 'Tabuenca'), " +
                    " ( 50, 'Talamantes'), " +
                    " ( 50, 'Tarazona'), " +
                    " ( 50, 'Tauste'), " +
                    " ( 50, 'Terrer'), " +
                    " ( 50, 'Tierga'), " +
                    " ( 50, 'Tobed'), " +
                    " ( 50, 'Torralba de los Frailes'), " +
                    " ( 50, 'Torralba de Ribota'), " +
                    " ( 50, 'Torralbilla'), " +
                    " ( 50, 'Torrehermosa'), " +
                    " ( 50, 'Torrelapaja'), " +
                    " ( 50, 'Torrellas'), " +
                    " ( 50, 'Torres de Berrellén'), " +
                    " ( 50, 'Torrijo de la Cañada'), " +
                    " ( 50, 'Tosos'), " +
                    " ( 50, 'Trasmoz'), " +
                    " ( 50, 'Trasobares'), " +
                    " ( 50, 'Uncastillo'), " +
                    " ( 50, 'Undués de Lerda'), " +
                    " ( 50, 'Urrea de Jalón'), " +
                    " ( 50, 'Urriés'), " +
                    " ( 50, 'Used'), " +
                    " ( 50, 'Utebo'), " +
                    " ( 50, 'Val de San Martín'), " +
                    " ( 50, 'Valdehorna'), " +
                    " ( 50, 'Valmadrid'), " +
                    " ( 50, 'Valpalmas'), " +
                    " ( 50, 'Valtorres'), " +
                    " ( 50, 'Velilla de Ebro'), " +
                    " ( 50, 'Velilla de Jiloca'), " +
                    " ( 50, 'Vera de Moncayo'), " +
                    " ( 50, 'Vierlas'), " +
                    " ( 50, 'Villadoz'), " +
                    " ( 50, 'Villafeliche'), " +
                    " ( 50, 'Villafranca de Ebro'), " +
                    " ( 50, 'Villalba de Perejil'), " +
                    " ( 50, 'Villalengua'), " +
                    " ( 50, 'Villamayor de Gállego'), " +
                    " ( 50, 'Villanueva de Gállego'), " +
                    " ( 50, 'Villanueva de Huerva'), " +
                    " ( 50, 'Villanueva de Jiloca'), " +
                    " ( 50, 'Villar de los Navarros'), " +
                    " ( 50, 'Villarreal de Huerva'), " +
                    " ( 50, 'Villarroya de la Sierra'), " +
                    " ( 50, 'Villarroya del Campo'), " +
                    " ( 50, 'Vilueña (La)'), " +
                    " ( 50, 'Vistabella'), " +
                    " ( 50, 'Zaida (La)'), " +
                    " ( 50, 'Zaragoza'), " +
                    " ( 50, 'Zuera'), " +
                    " ( 51, 'Ceuta'), " +
                    " ( 52, 'Melilla');");
                    */
                    stmt.close();
            } catch (SQLException e) {
                    e.printStackTrace();
            } finally {
                    this.close();
            }
    }

    public Statement getStatement() throws SQLException { //Se produce la conexion con la BD
            Statement stmt;// = null;
            // get connection
            conn = DriverManager.getConnection(url, user, pwd);
            stmt = conn.createStatement();
            return stmt;
    }

    public void close() {
            try {
                    if (conn != null) {
                            conn.close();
                            conn = null;
                    }
            } catch (SQLException e) {
                    e.printStackTrace();
            }
    }
}