package expr2.interpreter;

import de.itemis.interpreter.ExecutionContext;
import de.itemis.interpreter.logging.LogEntry;
import expr2.expr2Dsl.Assert;
import expr2.expr2Dsl.Expr;
import expr2.expr2Dsl.Formula;
import expr2.expr2Dsl.Return;
import expr2.expr2Dsl.VarDecl;

public class StatementExecutor extends AbstractExpr2DslStatementExecutor {

	public StatementExecutor(ExecutionContext ctx ) {
		super(ctx);
	}
	
	protected void executeVarDecl(VarDecl s, LogEntry log) {
		Expr init = ((VarDecl) s).getInit();
		if ( init != null) {
			ctx.environment.put(s, evalCheckNullLog( init, log ));
		}
	}
	
	protected void executeFormula(Formula s, LogEntry log) {
		ctx.environment.put(s, evalCheckNullLog( s.getExpr(), log ) );
	}
	
	protected void executeAssert(Assert s, LogEntry log) {
		Object expected = evalCheckNullLog( s.getExpected(), log );
		Object actual = evalCheckNullLog( s.getActual(), log );
		if ( !expected.equals(actual) ) {
			ctx.messages.addError(s, "Failed; expected "+expected+", but is "+actual );
		}
	}
	
	protected void executeReturn(Return s, LogEntry log) {
		ctx.environment.put(Evaluator.RETURN_SYMBOL, evalCheckNullLog(s.getExpr(), log));
	}

} 
