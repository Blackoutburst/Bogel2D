package org.blackoutburst.graphics;
/**
 * Couleur pré-définit et création de couleur personaliser
 * 
 * @author Blackoutburst
 *
 *@since 1.0
 *
 */
public class Colors {
	public float red;
	public float green;
	public float blue;
	public float alpha;
	
	/**
	 * Créer une couleur blanche est 100% visible
	 * 
	 * @since 1.2
	 * @author Blackoutburst
	 * 
	 */
	public Colors() {
		this(1,1,1,1);
	}
	
	
	/**
	 * Créer une nouvelle couleur customiser
	 * 
	 * @param red le rouge de la couleur
	 * @param green le vert de la couleur
	 * @param blue le bleu de la couleur
	 * @param alpha la transparence de la couleur
	 * 
	 * @since 1.2
	 * @author Blackoutburst
	 */
	
	public Colors(float red, float green, float blue, float alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}
	
	/**
	 * Créer une nouvelle couleur sans la transparence
	 * 
	 * @param red le rouge de la couleur
	 * @param green le vert de le couleur
	 * @param blue le bleu de la couleur
	 * 
	 * @since 1.2
	 * @author Blackoutburst
	 * 
	 */
	public Colors(float red, float green, float blue) {
		this(red, green, blue, 1);
	}
	
	
	/**
	 * La couleur noir avec une valeur RGBA (0,0,0,1)
	 * <div = style="border:2px solid white;width:20px;height:20px;background-color:rgb(0,0,0);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
	
	public static final Colors BLACK = new Colors(0,0,0);
	
	/**
	 * La couleur blanche avec une valeur RGBA (1,1,1,1)
	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(255,255,255);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
	
	public static final Colors WHITE = new Colors();
	
	/**
	 * La couleur grise avec une valeur RGBA (0.5f,0.5f,0.5f,1)
	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(127,127,127);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
	
    public static final Colors GRAY = new Colors(0.5f,0.5f,0.5f,1);
    
    /**
	 * La couleur rouge avec une valeur RGBA (1,0,0,1)
	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(255,0,0);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
    
    public static final Colors RED = new Colors(1,0,0,1);
    
    /**
	 * La couleur jaune avec une valeur RGBA (1,1,0,1)
	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(255,255,0);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
    
    public static final Colors YELLOW = new Colors(1,1,0,1);
    
    /**
	 * La couleur orange avec une valeur RGBA (1,0.5f,1,1)
	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(255,127,0);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
    
    public static final Colors ORANGE = new Colors(1,0.5f,0,1);
    
    /**
	 * La couleur verte avec une valeur RGBA (0,1,0,1)
	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(0,255,0);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
    
    public static final Colors GREEN = new Colors(0,1,0,1);
    
    /**
	 * La couleur violette avec une valeur RGBA (0.5f,0,0.5f,1)
	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(127,0,127);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
    
    public static final Colors PURPLE = new Colors(0.5f,0,0.5f,1);
    
    /**
	 * La couleur bleu avec une valeur RGBA (0,0,1,1)
	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(0,0,255);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
    
    public static final Colors BLUE = new Colors(0,0,1,1);
    
    /**
	 * La couleur cyan avec une valeur RGBA (0,1,1,1)
	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(0,255,255);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
    
    public static final Colors CYAN = new Colors(0,1,1,1);
    
    /**
	 * La couleur rose avec une valeur RGBA (1,0.4f,1,1)
	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(255,120,255);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
    
    public static final Colors PINK = new Colors(1,0.4f,1,1);
    
    /**
	 * La couleur magneta avec une valeur RGBA (1,0,1,1)
	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(255,0,255);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
    
    public static final Colors MAGENTA = new Colors(1, 0, 1, 1);
    
    /**
  	 * La couleur doré avec une valeur RGBA (1,1,0.3f,1)
  	 * <div = style="border:2px solid black;width:20px;height:20px;background-color:rgb(255,255,100);border-radius: 20px;float:right;margin: 0 10px 0 0"></div>
  	 * @author Blackoutburst
  	 * 
  	 * @since 1.0
  	 * 
  	 */
    
    public static final Colors GOLD = new Colors(1, 1, 0.3f, 1);
    
}
