# CoffeeMachineV2
/*
  PARTE 1:
	Modellare una macchinetta del caffé che permette di
		- erogare il caffe
		- ricaricare il caffe
		- ricaricare il latte
		- ricevere soldi
		- tiene conto di tutti i caffé erogati e dei soldi totali incassati
		- restituire il resto

	La macchinetta del caffé puó erogare diversi tipologie di caffe, ad esempio:
		- espresso
		- macchiato
		- cappuccino

	La macchinetta del caffé ha una erogazione limitata del caffé
		- se erogo un espresso o un macchiato o un cappuccino, la quantitá totale di caffé erogabile diminuisce.
		  Se non ho abbastanza caffé disponibile non posso erogare il caffé
		- il macchiato e il cappuccino consumano anche le quantitá disponibili di latte.
		  Se non ho abbastanza latte non posso erogare il tipo di caffé macchiato o cappuccino


  PARTE 2:
	Modellare il tipo di utente che puó interagire con la macchina del caffe; i clienti possono essere CUSTOMER o TECHNICIAN
	Alcuni metodi della macchina del caffé possono essere utilizzati solo dal TECHNICIAN, quali:
		- ricaricare il caffe
		- ricaricare il latte
		- verificare tutti i caffé erogati e dei soldi totali incassati
		- ritirare tutti i soldi incassati


  PARTE 3:
	Scrivere una classe main che permetta di interagire con la macchinettá del caffe
 */
