package alex;
import errors.GestionErrores;


public class AnalizadorLexicoTiny implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

  private ALexOperations ops;
  private GestionErrores errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public void fijaGestionErrores(GestionErrores errores) {
    this.errores = errores;
  }
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public AnalizadorLexicoTiny (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public AnalizadorLexicoTiny (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private AnalizadorLexicoTiny () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;

  ops = new ALexOperations(this);
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"3:8,4:2,1,3:2,4,3:18,4,44,3:2,50,34,45,3,35,36,33,31,5,32,49,2,7,6:9,48,47," +
"41,43,42,3:2,29:26,39,3,40,3,30,3,18,11,21,24,16,17,29,26,8,29,27,13,28,9,1" +
"2,23,29,14,19,10,15,20,25,29,22,29,37,46,38,3:65410,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,126,
"0,1:2,2,1,3,4,5,1,3:2,1:8,6,7,8,9,10,1:4,11,12,1:6,12:20,13,1,14,15,16,17,1" +
"8,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,4" +
"3,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,6" +
"8,12,69,70,71,72,73,74,75,76,77,78,79,80")[0];

	private int yy_nxt[][] = unpackFromString(81,51,
"1,2,3,4,2,5,6,57,7,58,103,111,113:2,115,113,117,118,113,119,120,121,113,122" +
",123,124,113:2,125,113,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,56,24," +
"25,26,27,-1:53,28,-1:54,6,-1:50,6:2,-1:49,113:3,59,113:7,29,113:13,-1:63,30" +
",-1:50,31,-1:50,32,-1:50,33,-1:52,34,-1:7,28:49,-1:6,113:25,-1:66,35,-1:10," +
"113:10,60,113:14,-1:26,113:4,36,113:20,-1:26,113:19,37,113:5,-1:26,113:9,74" +
",113:15,-1:26,113:17,104,113:7,-1:26,113:6,75,113:18,-1:26,113:10,76,113:14" +
",-1:26,113:4,77,113:20,-1:26,113:13,78,113:11,-1:26,113:8,38,113:16,-1:26,1" +
"13:3,39,113:21,-1:26,113:7,79,113:17,-1:26,113:8,108,113:16,-1:26,113:2,80," +
"113:22,-1:26,113:15,109,113:9,-1:26,113:11,107,113:13,-1:26,113:10,40,113:1" +
"4,-1:26,113:7,41,113:17,-1:26,113:12,87,113:12,-1:26,113:9,88,113:15,-1:26," +
"113:10,42,113:14,-1:26,113:13,89,113:11,-1:26,113:4,110,113:20,-1:26,113:18" +
",43,113:6,-1:26,113:10,44,113:14,-1:26,113:3,92,113:21,-1:26,113:7,94,113:1" +
"7,-1:26,113:3,45,113:21,-1:26,113:18,95,113:6,-1:26,113:21,46,113:3,-1:26,1" +
"13:8,96,113:16,-1:26,113:10,47,113:14,-1:26,113:15,97,113:9,-1:26,113:6,99," +
"113:18,-1:26,113:4,48,113:20,-1:26,113:9,100,113:15,-1:26,113:10,49,113:14," +
"-1:26,113:10,101,113:14,-1:26,113:3,50,113:21,-1:26,113:4,51,113:20,-1:26,1" +
"13:20,52,113:4,-1:26,113:8,53,113:16,-1:26,113:7,102,113:17,-1:26,113:11,54" +
",113:13,-1:26,113:4,55,113:20,-1:26,113:8,61,113:7,62,113:8,-1:26,113:10,86" +
",113:14,-1:26,113:13,82,113:11,-1:26,113:2,81,113:22,-1:26,113:12,93,113:12" +
",-1:26,113:9,90,113:15,-1:26,113:4,91,113:20,-1:26,113:15,98,113:9,-1:26,11" +
"3:6,63,113,64,113:16,-1:26,113:2,83,113:22,-1:26,113:2,84,113:22,-1:26,113:" +
"10,65,113:14,-1:26,113:2,85,113:22,-1:26,113:7,66,113:17,-1:26,113:6,67,113" +
":2,68,113:2,69,113:12,-1:26,113:4,70,113:14,71,113:5,-1:26,113:6,106,113:3," +
"72,113:14,-1:26,113:12,105,113:12,-1:26,113:8,112,113:16,-1:26,113:10,73,11" +
"3:14,-1:26,113:20,114,113:4,-1:26,113:12,116,113:12,-1:20");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  return ops.unidadEof();
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{}
					case -3:
						break;
					case 3:
						{return ops.unidadDiv();}
					case -4:
						break;
					case 4:
						{errores.errorLexico(fila(),lexema());}
					case -5:
						break;
					case 5:
						{return ops.unidadComa();}
					case -6:
						break;
					case 6:
						{return ops.unidadEnt();}
					case -7:
						break;
					case 7:
						{return ops.unidadIdentificador();}
					case -8:
						break;
					case 8:
						{return ops.unidadBarraBaja();}
					case -9:
						break;
					case 9:
						{return ops.unidadSuma();}
					case -10:
						break;
					case 10:
						{return ops.unidadResta();}
					case -11:
						break;
					case 11:
						{return ops.unidadMult();}
					case -12:
						break;
					case 12:
						{return ops.unidadMod();}
					case -13:
						break;
					case 13:
						{return ops.unidadParentesisAp();}
					case -14:
						break;
					case 14:
						{return ops.unidadParentesisCi();}
					case -15:
						break;
					case 15:
						{return ops.unidadLlaveAp();}
					case -16:
						break;
					case 16:
						{return ops.unidadLlaveCi();}
					case -17:
						break;
					case 17:
						{return ops.unidadCorAp();}
					case -18:
						break;
					case 18:
						{return ops.unidadCorCi();}
					case -19:
						break;
					case 19:
						{return ops.unidadMenor();}
					case -20:
						break;
					case 20:
						{return ops.unidadMayor();}
					case -21:
						break;
					case 21:
						{return ops.unidadIgual();}
					case -22:
						break;
					case 22:
						{return ops.unidadNot();}
					case -23:
						break;
					case 23:
						{return ops.unidadAmpersand();}
					case -24:
						break;
					case 24:
						{return ops.unidadPuntoComa();}
					case -25:
						break;
					case 25:
						{return ops.unidadDosPuntos();}
					case -26:
						break;
					case 26:
						{return ops.unidadPunto();}
					case -27:
						break;
					case 27:
						{return ops.unidadDollar();}
					case -28:
						break;
					case 28:
						{}
					case -29:
						break;
					case 29:
						{return ops.unidadIf();}
					case -30:
						break;
					case 30:
						{return ops.unidadMenorIgual();}
					case -31:
						break;
					case 31:
						{return ops.unidadMayorIgual();}
					case -32:
						break;
					case 32:
						{return ops.unidadIgualIgual();}
					case -33:
						break;
					case 33:
						{return ops.unidadNoIgual();}
					case -34:
						break;
					case 34:
						{return ops.unidadAnd();}
					case -35:
						break;
					case 35:
						{return ops.unidadOr();}
					case -36:
						break;
					case 36:
						{return ops.unidadInt();}
					case -37:
						break;
					case 37:
						{return ops.unidadNew();}
					case -38:
						break;
					case 38:
						{return ops.unidadFor();}
					case -39:
						break;
					case 39:
						{return ops.unidadFun();}
					case -40:
						break;
					case 40:
						{return ops.unidadTrue();}
					case -41:
						break;
					case 41:
						{return ops.unidadBool();}
					case -42:
						break;
					case 42:
						{return ops.unidadElse();}
					case -43:
						break;
					case 43:
						{return ops.unidadVoid();}
					case -44:
						break;
					case 44:
						{return ops.unidadCase();}
					case -45:
						break;
					case 45:
						{return ops.unidadMain();}
					case -46:
						break;
					case 46:
						{return ops.unidadBreak();}
					case -47:
						break;
					case 47:
						{return ops.unidadFalse();}
					case -48:
						break;
					case 48:
						{return ops.unidadPrint();}
					case -49:
						break;
					case 49:
						{return ops.unidadWhile();}
					case -50:
						break;
					case 50:
						{return ops.unidadReturn();}
					case -51:
						break;
					case 51:
						{return ops.unidadStruct();}
					case -52:
						break;
					case 52:
						{return ops.unidadSwitch();}
					case -53:
						break;
					case 53:
						{return ops.unidadVector();}
					case -54:
						break;
					case 54:
						{return ops.unidadTypedef();}
					case -55:
						break;
					case 55:
						{return ops.unidadDefault();}
					case -56:
						break;
					case 56:
						{errores.errorLexico(fila(),lexema());}
					case -57:
						break;
					case 57:
						{return ops.unidadEnt();}
					case -58:
						break;
					case 58:
						{return ops.unidadIdentificador();}
					case -59:
						break;
					case 59:
						{return ops.unidadIdentificador();}
					case -60:
						break;
					case 60:
						{return ops.unidadIdentificador();}
					case -61:
						break;
					case 61:
						{return ops.unidadIdentificador();}
					case -62:
						break;
					case 62:
						{return ops.unidadIdentificador();}
					case -63:
						break;
					case 63:
						{return ops.unidadIdentificador();}
					case -64:
						break;
					case 64:
						{return ops.unidadIdentificador();}
					case -65:
						break;
					case 65:
						{return ops.unidadIdentificador();}
					case -66:
						break;
					case 66:
						{return ops.unidadIdentificador();}
					case -67:
						break;
					case 67:
						{return ops.unidadIdentificador();}
					case -68:
						break;
					case 68:
						{return ops.unidadIdentificador();}
					case -69:
						break;
					case 69:
						{return ops.unidadIdentificador();}
					case -70:
						break;
					case 70:
						{return ops.unidadIdentificador();}
					case -71:
						break;
					case 71:
						{return ops.unidadIdentificador();}
					case -72:
						break;
					case 72:
						{return ops.unidadIdentificador();}
					case -73:
						break;
					case 73:
						{return ops.unidadIdentificador();}
					case -74:
						break;
					case 74:
						{return ops.unidadIdentificador();}
					case -75:
						break;
					case 75:
						{return ops.unidadIdentificador();}
					case -76:
						break;
					case 76:
						{return ops.unidadIdentificador();}
					case -77:
						break;
					case 77:
						{return ops.unidadIdentificador();}
					case -78:
						break;
					case 78:
						{return ops.unidadIdentificador();}
					case -79:
						break;
					case 79:
						{return ops.unidadIdentificador();}
					case -80:
						break;
					case 80:
						{return ops.unidadIdentificador();}
					case -81:
						break;
					case 81:
						{return ops.unidadIdentificador();}
					case -82:
						break;
					case 82:
						{return ops.unidadIdentificador();}
					case -83:
						break;
					case 83:
						{return ops.unidadIdentificador();}
					case -84:
						break;
					case 84:
						{return ops.unidadIdentificador();}
					case -85:
						break;
					case 85:
						{return ops.unidadIdentificador();}
					case -86:
						break;
					case 86:
						{return ops.unidadIdentificador();}
					case -87:
						break;
					case 87:
						{return ops.unidadIdentificador();}
					case -88:
						break;
					case 88:
						{return ops.unidadIdentificador();}
					case -89:
						break;
					case 89:
						{return ops.unidadIdentificador();}
					case -90:
						break;
					case 90:
						{return ops.unidadIdentificador();}
					case -91:
						break;
					case 91:
						{return ops.unidadIdentificador();}
					case -92:
						break;
					case 92:
						{return ops.unidadIdentificador();}
					case -93:
						break;
					case 93:
						{return ops.unidadIdentificador();}
					case -94:
						break;
					case 94:
						{return ops.unidadIdentificador();}
					case -95:
						break;
					case 95:
						{return ops.unidadIdentificador();}
					case -96:
						break;
					case 96:
						{return ops.unidadIdentificador();}
					case -97:
						break;
					case 97:
						{return ops.unidadIdentificador();}
					case -98:
						break;
					case 98:
						{return ops.unidadIdentificador();}
					case -99:
						break;
					case 99:
						{return ops.unidadIdentificador();}
					case -100:
						break;
					case 100:
						{return ops.unidadIdentificador();}
					case -101:
						break;
					case 101:
						{return ops.unidadIdentificador();}
					case -102:
						break;
					case 102:
						{return ops.unidadIdentificador();}
					case -103:
						break;
					case 103:
						{return ops.unidadIdentificador();}
					case -104:
						break;
					case 104:
						{return ops.unidadIdentificador();}
					case -105:
						break;
					case 105:
						{return ops.unidadIdentificador();}
					case -106:
						break;
					case 106:
						{return ops.unidadIdentificador();}
					case -107:
						break;
					case 107:
						{return ops.unidadIdentificador();}
					case -108:
						break;
					case 108:
						{return ops.unidadIdentificador();}
					case -109:
						break;
					case 109:
						{return ops.unidadIdentificador();}
					case -110:
						break;
					case 110:
						{return ops.unidadIdentificador();}
					case -111:
						break;
					case 111:
						{return ops.unidadIdentificador();}
					case -112:
						break;
					case 112:
						{return ops.unidadIdentificador();}
					case -113:
						break;
					case 113:
						{return ops.unidadIdentificador();}
					case -114:
						break;
					case 114:
						{return ops.unidadIdentificador();}
					case -115:
						break;
					case 115:
						{return ops.unidadIdentificador();}
					case -116:
						break;
					case 116:
						{return ops.unidadIdentificador();}
					case -117:
						break;
					case 117:
						{return ops.unidadIdentificador();}
					case -118:
						break;
					case 118:
						{return ops.unidadIdentificador();}
					case -119:
						break;
					case 119:
						{return ops.unidadIdentificador();}
					case -120:
						break;
					case 120:
						{return ops.unidadIdentificador();}
					case -121:
						break;
					case 121:
						{return ops.unidadIdentificador();}
					case -122:
						break;
					case 122:
						{return ops.unidadIdentificador();}
					case -123:
						break;
					case 123:
						{return ops.unidadIdentificador();}
					case -124:
						break;
					case 124:
						{return ops.unidadIdentificador();}
					case -125:
						break;
					case 125:
						{return ops.unidadIdentificador();}
					case -126:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
