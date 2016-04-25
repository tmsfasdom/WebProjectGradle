/*package br.com.tmsfasdom.utils.test;

import br.com.tmsfasdom.utils.AuxAD;
import junit.framework.TestCase;

public class TesteAuxAD extends TestCase{

	public void testValidaUsuarioValidoAD(){
		AuxAD ldapContxCrtn = new AuxAD();
		String mensagem = ldapContxCrtn.validaUsuarioAD("192.168.171.7", "administrator", "Ti&De&Fe", "tmsfasdom.com").getMensagem();
		assertTrue(mensagem.contentEquals(AuxAD.SUCESSO));
	}
	
	public void testValidaUsuarioInvalidoAD(){
		AuxAD ldapContxCrtn = new AuxAD();
		String mensagem = ldapContxCrtn.validaUsuarioAD("192.168.171.7", "administrator", "errado", "tmsfasdom.com").getMensagem();
		assertTrue(mensagem.contentEquals(AuxAD.ERROAUTENTICACAO));
	}
	
	public void testValidaUsuarioADConexaoErrada(){
		AuxAD ldapContxCrtn = new AuxAD();
		String mensagem = ldapContxCrtn.validaUsuarioAD("Errado", "administrator", "Ti&De&Fe", "tmsfasdom.com").getMensagem();
		assertTrue(mensagem.contentEquals(AuxAD.ERROCONEXAO));
	}
	
}
*/


