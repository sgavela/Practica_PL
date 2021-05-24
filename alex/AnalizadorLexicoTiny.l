package alex;
import errors.GestionErrores;

%%
%cup
%line
%class AnalizadorLexicoTiny
%unicode
%public

%{
  private ALexOperations ops;
  private GestionErrores errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public void fijaGestionErrores(GestionErrores errores) {
    this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*
numeroEntero = (([\+,\-]?{parteEntera})|0)
caracter = '[^\n]'
separador = [ \t\r\b\n]
comentario = \/\/[^\n]*
 
int = int
bool = bool
true = true
false = false
vector = vector
struct = struct
typedef = typedef
if = if
else = else
while = while
for = for
switch = switch
case = case
break = break
default = default
fun = fun
return = return
void = void
new = new
main = main
print = print

identificador = {letra}({letra}|{digito}|{barrabaja})*

operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = /
operadorMod = \%
parentesisApertura = \(
parentesisCierre = \)
llaveApertura = \{
llaveCierre = \}
corcheteApertura = \[
corcheteCierre = \]
operadorMenor = \<
operadorMayor = \>
operadorMenorIgual = \<\=
operadorMayorIgual = \>\=
igual = \=
operadorIgualIgual = \=\=
operadorNoIgual = \!\=
operadorAnd = \&\&
operadorOr = \|\|
operadorNot = \!
coma  = \,
puntoComa = \;
dosPuntos = \:
punto = \.
asterisco = \*
ampersand = \&
barrabaja = \_
dollar = \$
%%
{separador}               {}
{comentario}              {}
{numeroEntero}            {return ops.unidadEnt();}

{int}                     {return ops.unidadInt();}
{bool}                    {return ops.unidadBool();}
{true}                    {return ops.unidadTrue();}
{false}                   {return ops.unidadFalse();}
{vector}                  {return ops.unidadVector();}
{struct}                  {return ops.unidadStruct();}
{typedef}                 {return ops.unidadTypedef();}
{if}                      {return ops.unidadIf();}
{else}                    {return ops.unidadElse();}
{while}                   {return ops.unidadWhile();}
{for}                     {return ops.unidadFor();}
{switch}                  {return ops.unidadSwitch();}
{case}                    {return ops.unidadCase();}
{break}                   {return ops.unidadBreak();}
{default}                 {return ops.unidadDefault();}
{fun}                     {return ops.unidadFun();}
{return}                  {return ops.unidadReturn();}
{void}                    {return ops.unidadVoid();}
{new}                     {return ops.unidadNew();}
{main}                    {return ops.unidadMain();}
{print}                   {return ops.unidadPrint();}

{identificador}           {return ops.unidadIdentificador();}

{operadorSuma}            {return ops.unidadSuma();} 
{operadorResta}             {return ops.unidadResta();}
{operadorMultiplicacion}    {return ops.unidadMult();}
{operadorDivision}          {return ops.unidadDiv();}
{operadorMod}               {return ops.unidadMod();}
{parentesisApertura}        {return ops.unidadParentesisAp();}
{parentesisCierre}          {return ops.unidadParentesisCi();} 
{llaveApertura}             {return ops.unidadLlaveAp();}
{llaveCierre}               {return ops.unidadLlaveCi();}
{corcheteApertura}          {return ops.unidadCorAp();}
{corcheteCierre}            {return ops.unidadCorCi();}
{operadorMenor}             {return ops.unidadMenor();}
{operadorMayor}             {return ops.unidadMayor();}
{operadorMenorIgual}        {return ops.unidadMenorIgual();}
{operadorMayorIgual}        {return ops.unidadMayorIgual();}
{igual}                     {return ops.unidadIgual();}
{operadorIgualIgual}        {return ops.unidadIgualIgual();}
{operadorNoIgual}           {return ops.unidadNoIgual();}
{operadorAnd}               {return ops.unidadAnd();}
{operadorOr}                {return ops.unidadOr();}
{operadorNot}               {return ops.unidadNot();}
{coma}                      {return ops.unidadComa();}
{puntoComa}                 {return ops.unidadPuntoComa();}
{dosPuntos}                 {return ops.unidadDosPuntos();}
{punto}                     {return ops.unidadPunto();}
{asterisco}                 {return ops.unidadAsterisco();}
{ampersand}                 {return ops.unidadAmpersand();}
{barrabaja}                 {return ops.unidadBarraBaja();}
{dollar}                    {return ops.unidadDollar();}
[^]
{errores.errorLexico(fila(),lexema());}                           